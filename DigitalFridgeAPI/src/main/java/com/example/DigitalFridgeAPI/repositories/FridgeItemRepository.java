package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.Fridge;
import com.example.DigitalFridgeAPI.models.FridgeItem;
import com.example.DigitalFridgeAPI.models.FridgeItemCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeItemRepository extends JpaRepository<FridgeItem, Long> {

    List<FridgeItem> findAllByFridgeId (Long id);


}


