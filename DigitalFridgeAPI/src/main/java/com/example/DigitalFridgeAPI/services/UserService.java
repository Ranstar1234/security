package com.example.DigitalFridgeAPI.services;

import com.example.DigitalFridgeAPI.models.FavListItem;
import com.example.DigitalFridgeAPI.models.Favourites;
import com.example.DigitalFridgeAPI.models.Fridge;
import com.example.DigitalFridgeAPI.models.User;
import com.example.DigitalFridgeAPI.repositories.FavListItemRepository;
import com.example.DigitalFridgeAPI.repositories.FavouritesRepository;
import com.example.DigitalFridgeAPI.repositories.FridgeRepository;
import com.example.DigitalFridgeAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FavouritesRepository favouritesRepository;

    @Autowired
    FavListItemRepository favListItemRepository;

    @Autowired
    FridgeRepository fridgeRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
    public void addUser(Map<String, String> userParams) {
        String username = (userParams.get("username"));
        String password = (userParams.get("password"));
        String email = (userParams.get("email"));
        User user = new User(username, password,email);
        saveUser(user);
        }

    public void addFavList(String name, Long userId){
        User user = userRepository.findById(userId).get();
        Favourites favourites = new Favourites(name,user);
        favouritesRepository.save(favourites);
        user.setFavourites(favourites);
        saveUser(user);

    }
    public List<FavListItem> getAllFavListItems(Long id){
        return favListItemRepository.findAllByFavouritesId(id);
    }

    public void addFridgeToUser(Long userId, Long fridgeId){
        User user = userRepository.findById(userId).get();
        Fridge fridge = fridgeRepository.findById(fridgeId).get();
        user.addFridge(fridge);
        saveUser(user);
    }
    public List<Fridge> getAllFridgesByUser(long id) {
//        return fridgeRepository.findAllByUserId(id);
        User user = userRepository.findById(id).get();
        return user.getUserFridges();
    }
    public List<Favourites> getAllFavourites() {
        return favouritesRepository.findAll();
    }

    public Optional<Favourites> getFavouritesById(Long id) {
        return favouritesRepository.findById(id);
    }


    public void deleteFavourites(Long id) {
        favouritesRepository.deleteById(id);
    }

    public void addItemToFav(FavListItem favListItem){
        favListItemRepository.save(favListItem);
    }

    public void removeItemFromFav(Long id){
        favListItemRepository.deleteById(id);
    }

}

