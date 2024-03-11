package com.example.DigitalFridgeAPI.repositories;

import com.example.DigitalFridgeAPI.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {


    List<Fridge> findByName (String name);




}
