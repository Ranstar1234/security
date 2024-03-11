package com.example.DigitalFridgeAPI.services;

import com.example.DigitalFridgeAPI.models.FoodItem;
import com.example.DigitalFridgeAPI.models.FridgeItem;
import com.example.DigitalFridgeAPI.models.FridgeItemCompositeKey;
import com.example.DigitalFridgeAPI.models.User;
import com.example.DigitalFridgeAPI.repositories.FridgeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FridgeItemService {

    @Autowired
    FridgeItemRepository fridgeItemRepository;

    //add new Item
    public FridgeItem addNewItem (FridgeItem fridgeItem){
        fridgeItemRepository.save(fridgeItem);
        return fridgeItem;
    }

    //get all food items
    public List<FridgeItem> getAllFridgeItems(Long id){
         return fridgeItemRepository.findAllByFridgeId(id);
    }

//  get fridgeItem by ID
    public Optional<FridgeItem> getFridgeItemById(Long id){
        return fridgeItemRepository.findById(id);
    }

    public FridgeItem updateExpiryDate (Long id, Integer expiryDate) {
        FridgeItem fridgeItem = fridgeItemRepository.findById(id).get();
        fridgeItem.setExpiryDate(expiryDate);
        fridgeItemRepository.save(fridgeItem);
        return fridgeItem;
    }

    public void removeFridgeItem (Long id){
        fridgeItemRepository.deleteById(id);
    }

    //get item by name
//    public List<FridgeItem> getFridgeItemByName(String name){
//        //you want to search through the name of all the food items listed in the
//        fridgeItemRepository.findBy().
//        return;
//    }
    //delete item by Name


    //add to Shopping List
    //for it to access the food item ID, within the fridge item, and add that to the list
    public FoodItem getFoodItemFromFridgeItem(Long id) {
        Optional<FridgeItem> fridgeItem = fridgeItemRepository.findById(id);
        FoodItem fridgeItemFood = fridgeItem.get().getFoodItem();
        return fridgeItemFood;
    }
    }
    //add to favourites List



// return fridgeItemRepository.findById(id).get().getFridge().getReminderItems()

