package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}

