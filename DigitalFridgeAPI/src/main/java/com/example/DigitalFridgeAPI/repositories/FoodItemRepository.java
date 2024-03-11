package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.FoodGroup;
import com.example.DigitalFridgeAPI.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository <FoodItem, Long>  {


    Optional<FoodItem> findById(Long id);
   List<FoodItem> findByName(String name);
    List<FoodItem> findByFoodGroup(FoodGroup foodGroup);





}
