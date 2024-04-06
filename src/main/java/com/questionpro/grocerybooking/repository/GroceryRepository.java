package com.questionpro.grocerybooking.repository;

import com.questionpro.grocerybooking.model.db.GroceryItem;
import com.questionpro.grocerybooking.model.db.GroceryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroceryRepository extends JpaRepository<GroceryItem,Long> {

    void deleteByGroceryItemType(GroceryType groceryType);

    Optional<GroceryItem> findGroceryItemByGroceryItemType(GroceryType groceryType);

    List<GroceryItem> findAllByGroceryItemType(GroceryType groceryType);

}
