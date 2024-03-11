package com.example.DigitalFridgeAPI.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "fridge_items")
public class FridgeItem {

//    @EmbeddedId
//    @Column (name = "fridge_item_id")
//    private FridgeItemCompositeKey id;
//    private FridgeItemCompositeKey id = new FridgeItemCompositeKey();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "fridge_item_id")
    private Long id;


    //JOIN TO FRIDGE
    @ManyToOne
//    @MapsId("fridge_id")
    @JsonIgnoreProperties({"fridgeItems"})
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    //JOIN TO FOOD ITEM
    @ManyToOne
//    @MapsId("food_item_id")
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    //ADDITIONAL PROPERTIES
    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "expiry_date")
    private Integer expiryDate;

    @Column(name = "quantity")
    private Float quantity;

    //CONSTRUCTOR
    public FridgeItem( Fridge fridge, FoodItem foodItem, Integer expiryDate, Float quantity, boolean isExpired) {
//        this.id = new FridgeItemCompositeKey(fridge.getId(), foodItem.getId());
        this.fridge = fridge;
        this.foodItem = foodItem;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.isExpired = isExpired;
    }

    public FridgeItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public boolean getExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

}
