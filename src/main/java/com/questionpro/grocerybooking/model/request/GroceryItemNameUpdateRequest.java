package com.questionpro.grocerybooking.model.request;

import com.questionpro.grocerybooking.model.db.GroceryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroceryItemNameUpdateRequest {
    private String updatedGroceryName;
}
