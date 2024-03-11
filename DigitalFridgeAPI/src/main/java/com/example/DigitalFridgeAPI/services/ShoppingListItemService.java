package com.example.DigitalFridgeAPI.services;

import com.example.DigitalFridgeAPI.models.FridgeItem;
import com.example.DigitalFridgeAPI.models.ShoppingListItem;
import com.example.DigitalFridgeAPI.repositories.ShoppingListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShoppingListItemService{

    @Autowired
    ShoppingListItemRepository shoppingListItemRepository;

    public ShoppingListItem addNewItem (ShoppingListItem shoppingListItem){
        shoppingListItemRepository.save(shoppingListItem);
        return shoppingListItem;
    }

    public List<ShoppingListItem> getAllShoppingListItems(Long id){
    return shoppingListItemRepository.findAllByShoppingListId(id);

  }

    public Optional<ShoppingListItem> getShoppingListItemById(Long id) {
        return shoppingListItemRepository.findById(id);
    }

    public ShoppingListItem updateQuantity (Long id, Integer quantity) {
        ShoppingListItem shoppingListItem = shoppingListItemRepository.findById(id).get();
        shoppingListItem.setQuantity(quantity);
        shoppingListItemRepository.save(shoppingListItem);
        return shoppingListItem;
    }

    public ShoppingListItem updateShop (Long id, String shop) {
        ShoppingListItem shoppingListItem = shoppingListItemRepository.findById(id).get();
        shoppingListItem.setShop(shop);
        shoppingListItemRepository.save(shoppingListItem);
        return shoppingListItem;
    }


    public void removeShoppingListItem (Long id){
        shoppingListItemRepository.deleteById(id);
    }



}
