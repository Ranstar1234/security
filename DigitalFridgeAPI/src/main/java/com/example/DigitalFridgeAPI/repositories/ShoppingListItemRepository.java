package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.FridgeItem;
import com.example.DigitalFridgeAPI.models.ShoppingListItem;
import com.example.DigitalFridgeAPI.models.ShoppingListItemCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {

    List<ShoppingListItem>findAllByShoppingListId(Long id);


}
