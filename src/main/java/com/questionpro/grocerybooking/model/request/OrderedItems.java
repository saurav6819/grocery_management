package com.questionpro.grocerybooking.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderedItems {
    private long groceryItemId;
    private long quantity;
}
