package com.example.DigitalFridgeAPI.controllers;


import com.example.DigitalFridgeAPI.models.FoodGroup;
import com.example.DigitalFridgeAPI.models.FoodItem;
import com.example.DigitalFridgeAPI.repositories.FoodItemRepository;
import com.example.DigitalFridgeAPI.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/foodItems")    //@RequestMapping = endpoint
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    FoodItemRepository foodItemRepository;

//GET METHODS (show)

    //Method 1: get all foodItems - grab all the foodItems from foodItemRepository (our database)

    @GetMapping // localhost:8080/foodItems
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        // the controller will call the getAllFoodItems method from the foodItemService
//        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItemRepository.findAll(), HttpStatus.OK);

    }

    //method: find foodItem by name:
    @GetMapping(value = "/byName/{name}")   //localhost:8080/foodItems/byName/carrots (or any foodItem name)
    public ResponseEntity<List<FoodItem>> getFoodItemsByName(
            @PathVariable String name) {

        List<FoodItem> foodItem = foodItemService.getFoodItemByName(name);
            return new ResponseEntity<>(foodItem, HttpStatus.OK);
    }

    //method: find foodItem by food Group: 
    @GetMapping(value = "/foodGroup")   //localhost:8080/foodItems/foodGroup + type enum in JSON e.g. "VEGETABLES"
    public ResponseEntity<List<FoodItem>> getFoodItemByFoodGroup(
            @RequestBody FoodGroup foodGroup
            ){
        List<FoodItem> foodItems = foodItemService.getAllFoodItemsByFoodGroup(foodGroup);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    //Method to get foodItem by id:
    @GetMapping("/{id}") // localhost:8080/foodItems/2
    public ResponseEntity<FoodItem> getFoodItemsById(@PathVariable Long id) {
        Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
        if (foodItem.isPresent()) {
            return new ResponseEntity<>(foodItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
//POST MAPPING (create)

    //method to add a new foodItem:

    @PostMapping("/add") //localhost:8080/foodItems/add
    
    public ResponseEntity<FoodItem> addNewFoodItem(@RequestBody FoodItem newFoodItem){
        foodItemRepository.save(newFoodItem);
        return new ResponseEntity<>(newFoodItem, HttpStatus.CREATED);

//    @PostMapping("/add")
//    public ResponseEntity<FoodItem> addNewFoodItem(@RequestBody String name,
//                                                   @RequestBody FoodGroup foodGroup
//                                                   ){
//
//        FoodItem addNewFoodItem = new FoodItem(name,foodGroup);
//        foodItemService.saveFoodItem(addNewFoodItem);
//        System.out.println("FoodItem" + name + " has been added!");
//        return ResponseEntity.ok().body(addNewFoodItem);
    }

//DELETE MAPPING (remove)
    @DeleteMapping("/delete/{id}") //localhost:8080/foodItems/delete/1 (or any other id)
    public ResponseEntity <String> deleteById(@PathVariable Long id) {

        String foodItemName = foodItemService.getFoodItemById(id).get().getName();
        String message = String.format("The food Item: ( %s ) has been removed", foodItemName);
        foodItemService.deleteFoodItemById(id);
        return new ResponseEntity<>(message,HttpStatus.OK);


    }







}
