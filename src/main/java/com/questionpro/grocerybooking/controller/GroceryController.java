package com.questionpro.grocerybooking.controller;

import com.questionpro.grocerybooking.model.db.GroceryItem;
import com.questionpro.grocerybooking.model.db.GroceryType;
import com.questionpro.grocerybooking.model.db.OrderedGroceryItem;
import com.questionpro.grocerybooking.model.db.UserOrders;
import com.questionpro.grocerybooking.model.request.BookGroceryItemsRequest;
import com.questionpro.grocerybooking.model.request.GroceryItemNameUpdateRequest;
import com.questionpro.grocerybooking.model.request.GroceryItemPriceUpdateRequest;
import com.questionpro.grocerybooking.service.GroceryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
@AllArgsConstructor
public class GroceryController {
    private final GroceryService groceryService;

    @GetMapping
    public List<GroceryItem> getAllGrocery() {
        return groceryService.getGroceryItems();
    }

    @PostMapping
    public GroceryItem addGrocery(@RequestBody GroceryItem groceryItem) {
        return groceryService.addGrocery(groceryItem);
    }

    @PatchMapping("/grocery-name/{groceryId}")
    public GroceryItem updateGroceryItemName(@PathVariable long groceryId, @RequestBody GroceryItemNameUpdateRequest groceryItemNameUpdateRequest) {
        return groceryService.updateGroceryItemName(groceryId,groceryItemNameUpdateRequest);
    }

    @PatchMapping("/grocery-price/{groceryId}")
    public GroceryItem updateGroceryItemPrice(@PathVariable long groceryId, @RequestBody GroceryItemPriceUpdateRequest groceryItemPriceUpdateRequest) {
        return groceryService.updateGroceryItemPrice(groceryId,groceryItemPriceUpdateRequest);
    }

    @GetMapping("/{groceryType}")
    public List<GroceryItem> getGroceryItemByGroceryType(@PathVariable GroceryType groceryType) {
        return groceryService.getAllGroceriesByGroceryType(groceryType);
    }

    @PostMapping("/order-grocery")
    public UserOrders orderGrocery(@RequestBody BookGroceryItemsRequest bookGroceryItemsRequest) {
        return groceryService.bookGroceryItem(bookGroceryItemsRequest);
    }
}
