package com.example.DigitalFridgeAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

//@Entity is a table named = "..." :
@Entity(name= "food_items")
public class FoodItem {

    //    PROPERTIES:::::::::::::;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private FoodGroup foodGroup;

    //@JsonIgnoreProperties TO AVOID INFINITE dependencies LOOP ISSUE.
    @JsonIgnoreProperties(value = {"food_items"})

    // //FOODITEM TO FRIDGE JOIN
    @OneToMany(mappedBy = "foodItem")
    Set<FridgeItem> expiryDate;

    @OneToMany(mappedBy = "foodItem")
    Set<FridgeItem> quantity;

    ////FOOD ITEM TO SHOPPING JOIN
    @OneToMany(mappedBy = "foodItem")
    Set<FridgeItem> shoppingQuantity;
    //to paste  into food item
    

    //    CONSTRUCTOR::::::::::

    public FoodItem(String name, FoodGroup foodGroup) {
        this.name = name;
        this.foodGroup = foodGroup;



    }

    // no arg constructor/ empty constructor
    public FoodItem(){

    }

    //GETTERS + SETTERS ::::::::::::::

    //For the id property:
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //For the Name Property:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //For the FoodGroup Property:
    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }


}