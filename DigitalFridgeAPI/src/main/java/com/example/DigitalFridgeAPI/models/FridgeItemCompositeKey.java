package com.example.DigitalFridgeAPI.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FridgeItemCompositeKey implements Serializable {


    @Column(name = "fridge_id")
    Long fridgeId;

    @Column(name = "food_item_id")
    Long foodItemId;

    public FridgeItemCompositeKey(Long fridgeId, Long foodItemId) {
        this.fridgeId = fridgeId;
        this.foodItemId = foodItemId;
    }

    public FridgeItemCompositeKey() {
    }

    public Long getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(Long fridgeId) {
        this.fridgeId = fridgeId;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;


    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FridgeItemCompositeKey that = (FridgeItemCompositeKey) o;
//        return Objects.equals(fridgeId, that.fridgeId) && Objects.equals(foodItemId, that.foodItemId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(fridgeId, foodItemId);
//    }
}



