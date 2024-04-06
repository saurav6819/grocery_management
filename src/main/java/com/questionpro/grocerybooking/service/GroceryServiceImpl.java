package com.questionpro.grocerybooking.service;

import com.questionpro.grocerybooking.model.db.*;
import com.questionpro.grocerybooking.model.request.*;
import com.questionpro.grocerybooking.repository.GroceryRepository;
import com.questionpro.grocerybooking.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;
    private final UserRepository userRepository;

    @Override
    public GroceryItem addGrocery(GroceryItem groceryItem) {
        log.info("Adding grocery item: {}", groceryItem.getGroceryItemName());
        return groceryRepository.save(groceryItem);
    }

    @Override
    public List<GroceryItem> getAllGroceriesByGroceryType(GroceryType groceryType) {
        return groceryRepository.findAllByGroceryItemType(groceryType);
    }

    private Optional<GroceryItem> getGroceryByGroceryType(GroceryType groceryType) {
        return groceryRepository.findGroceryItemByGroceryItemType(groceryType);
    }

    public Optional<GroceryItem> getGroceryItemByGroceryItemId(long groceryItemId) {
        return groceryRepository.findById(groceryItemId);
    }

    @Override
    public void deleteGroceryItem(long groceryItemId) {
        log.info("Deleting Grocery item: {}", groceryItemId);
        Optional<GroceryItem> groceryItemByGroceryType = getGroceryItemByGroceryItemId(groceryItemId);

        if (groceryItemByGroceryType.isPresent()) {
            groceryRepository.delete(groceryItemByGroceryType.get());
            log.info("Grocery item deleted: {}", groceryItemByGroceryType.get().getGroceryItemName());
            return;
        }
        log.warn("No Grocery exists with grocery item id: {}", groceryItemId);
    }

    @Override
    public GroceryItem updateGroceryItemName(long groceryId, GroceryItemNameUpdateRequest groceryItemNameUpdateRequest) {
        log.info("Updating grocery name of grocery item: {}", groceryId);
        Optional<GroceryItem> groceryItemByGroceryType = getGroceryItemByGroceryItemId(groceryId);

        if (groceryItemByGroceryType.isPresent()) {
            GroceryItem groceryItem = groceryItemByGroceryType.get();
            groceryItem.setGroceryItemName(groceryItemNameUpdateRequest.getUpdatedGroceryName());
            return groceryRepository.save(groceryItem);
        }
        throw new ObjectNotFoundException(groceryId, " Grocery doesn't exists");
    }

    @Override
    public GroceryItem updateGroceryItemPrice(long groceryId, GroceryItemPriceUpdateRequest groceryItemPriceUpdateRequest) {
        log.info("Updating grocery price of grocery item: {}", groceryId);
        Optional<GroceryItem> groceryItemByGroceryType = getGroceryItemByGroceryItemId(groceryId);

        if (groceryItemByGroceryType.isPresent()) {
            GroceryItem groceryItem = groceryItemByGroceryType.get();
            groceryItem.setGroceryItemPrice(groceryItemPriceUpdateRequest.getUpdatedGroceryPrice());
            return groceryRepository.save(groceryItem);
        }
        throw new ObjectNotFoundException(groceryId, " Grocery doesn't exists");
    }

    @Override
    public GroceryItem updateGroceryItemStock(long groceryId, GroceryItemStockUpdateRequest groceryItemStockUpdateRequest) {
        log.info("Updating grocery price of grocery item: {}", groceryId);
        Optional<GroceryItem> groceryItemByGroceryType = getGroceryItemByGroceryItemId(groceryId);

        if (groceryItemByGroceryType.isPresent()) {
            GroceryItem groceryItem = groceryItemByGroceryType.get();
            groceryItem.addStock(groceryItemStockUpdateRequest.getUpdatedStock());
            return groceryRepository.save(groceryItem);
        }
        throw new ObjectNotFoundException(groceryId, " Grocery doesn't exists");
    }

    @Override
    public List<GroceryItem> getGroceryItems() {
        return groceryRepository.findAll();
    }

    @Override
    public UserOrders bookGroceryItem(BookGroceryItemsRequest bookGroceryItemsRequest) {
        Optional<User> optionalUser = userRepository.findById(bookGroceryItemsRequest.getUserId());
        if (optionalUser.isPresent()) {
            UserOrders userOrders = new UserOrders();

            bookGroceryItemsRequest.getGroceryItemList().forEach(groceryItem -> {
                addGroceryItemToUsersOrder(groceryItem, userOrders);
            });

            User user = optionalUser.get();
            user.getGroceryItemList().add(userOrders);
            userRepository.save(user);
            return userOrders;
        }

        throw new ObjectNotFoundException("User doesn't exists", bookGroceryItemsRequest.getUserId());
    }

    private void addGroceryItemToUsersOrder(OrderedItems groceryItem, UserOrders userOrders) {
        Optional<GroceryItem> groceryItemById = groceryRepository.findById(groceryItem.getGroceryItemId());
        if (groceryItemById.isPresent()) {
            GroceryItem item = groceryItemById.get();

            OrderedGroceryItem orderedGroceryItem = OrderedGroceryItem.builder()
                    .groceryItemName(item.getGroceryItemName())
                    .orderedGroceryItemId(item.getGroceryItemId())
                    .groceryItemPrice(item.getGroceryItemPrice())
                    .totalQuantity(groceryItem.getQuantity())
                    .build();

            userOrders.getGroceryItems().add(orderedGroceryItem);
            userOrders.setTotalOrderValue(userOrders.getTotalOrderValue() + (item.getGroceryItemPrice()* groceryItem.getQuantity()));
            userOrders.setOrderedDate(new Date());

            updateGroceryItemStock(item, groceryItem.getQuantity());
        }
    }

    private void updateGroceryItemStock(GroceryItem groceryItem, long consumedStock) {
        groceryItem.removeStock(consumedStock);
        groceryRepository.save(groceryItem);
    }
}


