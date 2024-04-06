package com.questionpro.grocerybooking.model.request;

import com.questionpro.grocerybooking.model.db.GroceryType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GroceryItemPriceUpdateRequest {
    private long groceryItemId;
    private Double updatedGroceryPrice;
}
