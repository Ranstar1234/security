package com.example.DigitalFridgeAPI.controllers;

import com.example.DigitalFridgeAPI.models.*;
import com.example.DigitalFridgeAPI.services.FoodItemService;
import com.example.DigitalFridgeAPI.services.FridgeService;
import com.example.DigitalFridgeAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    FridgeService fridgeService;

//    get a list of users
    @GetMapping  //?
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    get a user by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


//    adding a new user

    @PostMapping
    public ResponseEntity addNewUser(@RequestBody Map<String, String> userParams) {
        userService.addUser(userParams);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


//    deleting a user

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
//    add a fridge to user
    @PostMapping(value="/fridge/{userId}/{fridgeId}")
    public ResponseEntity addFridge(@PathVariable Long userId,@PathVariable Long fridgeId) {
        userService.addFridgeToUser(userId,fridgeId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

//    adding a favourites list to user
    @PostMapping(value="/favourites/{userId}")
    public ResponseEntity addFavList(@RequestBody Map<String, String> bodyParams,@PathVariable Long userId) {
        userService.addFavList(bodyParams.get("name"),userId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }



//    add items to favourites list

    @PostMapping("/favourites/{favId}/{foodItemId}")
    public ResponseEntity<FavListItem> addNewFridgeItem(
            @PathVariable Long favId,
            @PathVariable Long foodItemId
    )

    {   Favourites favourites = userService.getFavouritesById(favId).get();
        FoodItem foodItem = foodItemService.getFoodItemById(foodItemId).get();
        FavListItem favlistItem = new FavListItem(favourites,foodItem);
        userService.addItemToFav(favlistItem);
        return ResponseEntity.ok().body(favlistItem);
    }

//    remove item from favourites list

    @DeleteMapping(value = "/favourites/{id}")
    public ResponseEntity deleteFavItem(@PathVariable Long id) {
        userService.removeItemFromFav(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
//    get all items in a favourites list
    @GetMapping("/favourites/{favouritesId}")
    public ResponseEntity<List<FavListItem>> getAllFavItems(@PathVariable Long favouritesId) {
        List<FavListItem> favListItems = userService.getAllFavListItems(favouritesId);
        return new ResponseEntity<>(favListItems, HttpStatus.OK);
    }

//    get fridges by userID
    @GetMapping(value="/fridge/{userId}")
    public ResponseEntity<List<Fridge>> getFridgesByUser(@PathVariable Long userId) {
        List<Fridge> fridges = userService.getAllFridgesByUser(userId);
        return new ResponseEntity<>(fridges, HttpStatus.OK);
    }





}
