package com.questionpro.grocerybooking.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GroceryItemStockUpdateRequest {
    private long updatedStock;
}
