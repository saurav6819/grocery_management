package com.questionpro.grocerybooking.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BookGroceryItemsRequest {
    private List<OrderedItems> groceryItemList;
    private Long userId;
}
