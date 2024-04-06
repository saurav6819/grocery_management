package com.questionpro.grocerybooking.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "grocery_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groceryItemId;
    private String groceryItemName;
    @Enumerated(EnumType.STRING)
    private GroceryType groceryItemType;
    private Double groceryItemPrice;
    private long groceryTotalStock;

    public void addStock(long stockValue) {
        this.groceryTotalStock = this.groceryTotalStock+stockValue;
    }

    public void removeStock(long stockValue) {
        this.groceryTotalStock = this.groceryTotalStock-stockValue;
    }
}
