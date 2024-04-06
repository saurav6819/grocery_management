package com.questionpro.grocerybooking.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ordered_grocery_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedGroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderedGroceryItemId;
    private String groceryItemName;
    private Double groceryItemPrice;
    private long totalQuantity;

}
