package com.example.DigitalFridgeAPI.controllers;

import com.example.DigitalFridgeAPI.models.*;
import com.example.DigitalFridgeAPI.services.*;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
//@RequestMapping = endpoint
@RequestMapping("/fridges")
public class FridgeController {

    @Autowired
    FridgeService fridgeService;

    @Autowired
    FridgeItemService fridgeItemService;
    @Autowired
    FoodItemService foodItemService;

    @Autowired
    ShoppingListService shoppingListService;

    @Autowired
    ShoppingListItemService shoppingListItemService;

// FRIDGE METHODS ---
    @GetMapping
    public ResponseEntity<List<Fridge>> getAllFridges() {
        List<Fridge> fridges = fridgeService.getAllFridges();
        return new ResponseEntity<>(fridges, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Fridge> getFridgebyID(@PathVariable Long id) {
        Optional<Fridge> fridge = fridgeService.getFridgeByID(id);
        return fridge.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Fridge> addNewFridge(@RequestBody Fridge fridge){
        Fridge newFridge = fridgeService.addNewFridge(fridge);

        return new ResponseEntity<>(fridge, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFridgeById(@PathVariable Long id){
        fridgeService.removeFridge(id);
        String message = "Fridge" + id + " has been deleted";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    //FRIDGE ITEMS ----

    @GetMapping("/{fridgeId}/fridgeItem")
    public ResponseEntity<List<FridgeItem>> getAllFridgeItems(@PathVariable Long fridgeId) {
        List<FridgeItem> fridgeItems = fridgeItemService.getAllFridgeItems(fridgeId);
        return new ResponseEntity<>(fridgeItems, HttpStatus.OK);
    }


    @GetMapping("/fridgeItem/{id}")
    public ResponseEntity<FridgeItem> getFridgeItemByID(@PathVariable Long id) {
        Optional <FridgeItem> fridgeItem = fridgeItemService.getFridgeItemById(id);
        if (fridgeItem.isPresent()) {
            return new ResponseEntity<>(fridgeItem.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{fridgeId}/{foodItemId}/fridgeItem")
    public ResponseEntity<FridgeItem> addNewFridgeItem(
            @PathVariable Long fridgeId,
            @PathVariable Long foodItemId,
            @RequestBody FridgeItem request
            )

    {   System.out.println("first print");
        Fridge fridge = fridgeService.getFridgeByID(fridgeId).get();
        FoodItem foodItem = foodItemService.getFoodItemById(foodItemId).get();
        System.out.println("worked till here");
        FridgeItem fridgeItem = new FridgeItem(fridge,foodItem, request.getExpiryDate(), request.getQuantity(), request.getExpired());
        fridgeItemService.addNewItem(fridgeItem);
        return ResponseEntity.ok().body(fridgeItem);
    }

    @PatchMapping(value = "/fridgeItem/{id}")
    public ResponseEntity<FridgeItem> updateFridgeItemExpiryDate(@PathVariable Long id, @RequestBody RequestPojo request) {
        FridgeItem fridgeItem = fridgeItemService.getFridgeItemById(id).get();
        fridgeItemService.updateExpiryDate(id, request.getExpiryDate());
        return new ResponseEntity<>(fridgeItem, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/foodItem/{id}")
    public ResponseEntity<String> deleteFridgeItemById(@PathVariable Long id){
        fridgeItemService.removeFridgeItem(id);
        String message = "FridgeItem" + id + " has been deleted";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

// SHOPPING LIST ITEMS---------

    @PostMapping(value="/{fridgeId}/shoppingList")
    public ResponseEntity addShoppingList( @RequestBody ShoppingList shoppingList,
                                           @PathVariable Long fridgeId)
    {
        fridgeService.addShoppingList(shoppingList.getName(), fridgeId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/shoppingList/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable Long id) {
        Optional <ShoppingList> shoppingList = shoppingListService.getShoppingListByID(id);
        return shoppingList.map(list -> new ResponseEntity<>(list, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

   // Post a shopping List Item
    @PostMapping("/shoppingList/{shoppingListId}/{foodItemId}")
    public ResponseEntity<ShoppingListItem> addNewShoppingListItem(
            @PathVariable Long shoppingListId,
            @PathVariable Long foodItemId,
            @RequestBody ShoppingListItem shoppingListItem)
    {
        ShoppingList shoppingList = shoppingListService.getShoppingListByID(shoppingListId).get();
        FoodItem foodItem = foodItemService.getFoodItemById(foodItemId).get();
        ShoppingListItem newShoppingListItem = new ShoppingListItem(shoppingList, foodItem, shoppingListItem.getQuantity(), shoppingListItem.getShop());
        shoppingListItemService.addNewItem(newShoppingListItem);
        return ResponseEntity.ok().body(newShoppingListItem);
    }

//    //---Get Shopping List Item by ID --
//
    @GetMapping("shoppingList/shoppingListItem/{id}")
    public ResponseEntity<ShoppingListItem> getShoppingListItemById(@PathVariable Long id) {
        Optional <ShoppingListItem> shoppingListItem = shoppingListItemService.getShoppingListItemById(id);
        if (shoppingListItem.isPresent()) {
            return new ResponseEntity<>(shoppingListItem.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/shoppingList/shoppingListItem/{id}/quantity")
    public ResponseEntity<ShoppingListItem> updateShoppingListItemQuantity(@PathVariable Long id, @RequestBody ShoppingListItem shoppingListItem) {
        ShoppingListItem updatedShoppingListItem = shoppingListItemService.getShoppingListItemById(id).get();
        shoppingListItemService.updateQuantity(id, shoppingListItem.getQuantity());
        return new ResponseEntity<>(updatedShoppingListItem, HttpStatus.OK);
    }

    @PatchMapping(value = "/shoppingList/shoppingListItem/{id}/shop")
    public ResponseEntity<ShoppingListItem> updateShoppingListItemShop(@PathVariable Long id, @RequestBody ShoppingListItem shoppingListItem) {
        ShoppingListItem updatedShoppingListItem = shoppingListItemService.getShoppingListItemById(id).get();
        shoppingListItemService.updateShop(id, shoppingListItem.getShop());
        return new ResponseEntity<>(updatedShoppingListItem, HttpStatus.OK);
    }


   // - Delete shopping List Item by ID
    @DeleteMapping(value = "shoppingList/shoppingListItem/{id}")
    public ResponseEntity<String> deleteShoppingListItemById(@PathVariable Long id){
        shoppingListItemService.removeShoppingListItem(id);
        String message = "Shopping List Item " + id + " has been deleted";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PostMapping("/fridgeItem/{fridgeItemId}/{shoppingListId}")
    public ResponseEntity<ShoppingListItem> addFridgeItemtoShoppingList(
            @PathVariable Long shoppingListId,
            @PathVariable Long fridgeItemId,
            @RequestBody ShoppingListItem shoppingListItem)
    {
        ShoppingList shoppingList = shoppingListService.getShoppingListByID(shoppingListId).get();
        FoodItem foodItem = fridgeItemService.getFoodItemFromFridgeItem(fridgeItemId);

        ShoppingListItem newShoppingListItem = new ShoppingListItem(shoppingList, foodItem, shoppingListItem.getQuantity(), shoppingListItem.getShop());
        shoppingListItemService.addNewItem(newShoppingListItem);
        return ResponseEntity.ok().body(newShoppingListItem);
    }

//    @PostMapping("/shoppingList/shoppingListItem/{shoppingListItemId}/{fridgeId}")
//    public ResponseEntity<ShoppingListItem> addShoppingListItemtoFridgeList(
//            @PathVariable Long shoppingListItemId,
//            @PathVariable Long fridgeId,
//            @RequestBody FridgeItem fridgeItem)
//    {
//        ShoppingList shoppingList = shoppingListService.getShoppingListByID(shoppingListId).get();
//        FoodItem foodItem = fridgeItemService.getFoodItemFromFridgeItem(fridgeId);
//
//        ShoppingListItem newShoppingListItem = new ShoppingListItem(shoppingList, foodItem, shoppingListItem.getQuantity(), shoppingListItem.getShop());
//        shoppingListItemService.addNewItem(newShoppingListItem);
//        return ResponseEntity.ok().body(newFridgeItem);
//    }

//    public ResponseEntity<FridgeItem> addNewFridgeItem(
//            @PathVariable Long fridgeId,
//            @PathVariable Long foodItemId,
//            @RequestBody RequestPojo request
//    )
//
//    {   System.out.println("first print");
//        Fridge fridge = fridgeService.getFridgeByID(fridgeId).get();
//        FoodItem foodItem = foodItemService.getFoodItemById(foodItemId).get();
//        System.out.println("worked till here");
//        FridgeItem fridgeItem = new FridgeItem(fridge,foodItem, request.getExpiryDate(), request.getQuantity(), request.getExpired());
//        fridgeItemService.addNewItem(fridgeItem);
//        return ResponseEntity.ok().body(fridgeItem);
//    }




}

    //Add fridge Item to Shopping List/Item




    //Get a fridge by name
//    @GetMapping
//    public ResponseEntity<List<Fridge>> getFridgebyName(name) {
//        List<Fridge> fridges = fridgeService.getFridgeByName(name);
//        return new ResponseEntity<>(fridges, HttpStatus.OK);
//    }

    //Get Shopping List by Name

    //Get Shopping List for every fridge the user is attached to  - frontend?






