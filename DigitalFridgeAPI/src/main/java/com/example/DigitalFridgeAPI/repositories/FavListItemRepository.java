package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.FavListItem;

import com.example.DigitalFridgeAPI.models.FridgeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavListItemRepository extends JpaRepository<FavListItem, Long> {


    List<FavListItem> findAllByFavouritesId (Long id);
}

