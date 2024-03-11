package com.example.DigitalFridgeAPI.repositories;
import com.example.DigitalFridgeAPI.models.Favourites;
import com.example.DigitalFridgeAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


//    to do:
//    return a list of favourite food items??
//    List<FoodItem> findAllByUserId(long id);
}
