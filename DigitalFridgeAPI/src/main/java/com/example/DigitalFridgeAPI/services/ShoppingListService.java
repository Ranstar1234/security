package com.example.DigitalFridgeAPI.services;

import com.example.DigitalFridgeAPI.models.Fridge;
import com.example.DigitalFridgeAPI.models.ShoppingList;
import com.example.DigitalFridgeAPI.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    public ShoppingList addNewShoppingList (ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
        return shoppingList;
    }

    public List<ShoppingList> getAllShoppingLists(){
        return shoppingListRepository.findAll();
    }

    public Optional<ShoppingList> getShoppingListByID(Long id){
        return shoppingListRepository.findById(id);
    }






}
