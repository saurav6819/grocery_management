package com.questionpro.grocerybooking.service;

import com.questionpro.grocerybooking.model.db.GroceryItem;
import com.questionpro.grocerybooking.model.db.GroceryType;
import com.questionpro.grocerybooking.model.db.UserOrders;
import com.questionpro.grocerybooking.model.request.BookGroceryItemsRequest;
import com.questionpro.grocerybooking.model.request.GroceryItemNameUpdateRequest;
import com.questionpro.grocerybooking.model.request.GroceryItemPriceUpdateRequest;
import com.questionpro.grocerybooking.model.request.GroceryItemStockUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface GroceryService {
    GroceryItem addGrocery(GroceryItem groceryItem);

    List<GroceryItem> getAllGroceriesByGroceryType(GroceryType groceryItem);

    void deleteGroceryItem(long groceryItemId);

    Optional<GroceryItem> getGroceryItemByGroceryItemId(long groceryItemId);

    GroceryItem updateGroceryItemName(long groceryId, GroceryItemNameUpdateRequest groceryItemNameUpdateRequest);

    GroceryItem updateGroceryItemPrice(long groceryId, GroceryItemPriceUpdateRequest groceryItemPriceUpdateRequest);

    GroceryItem updateGroceryItemStock(long groceryId, GroceryItemStockUpdateRequest groceryItemStockUpdateRequest);
    List<GroceryItem> getGroceryItems();

    UserOrders bookGroceryItem(BookGroceryItemsRequest bookGroceryItemsRequest);
}
