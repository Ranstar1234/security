package com.example.DigitalFridgeAPI.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


    @Embeddable
    public class ShoppingListItemCompositeKey  implements Serializable {


        @Column(name = "shopping_list_id")
        Long shoppingListId;

        @Column(name = "food_item_id")
        Long foodItemId;

        public ShoppingListItemCompositeKey(Long shoppingListId, Long foodItemId) {
            this.shoppingListId = shoppingListId;
            this.foodItemId = foodItemId;
        }

        public ShoppingListItemCompositeKey() {
        }

        public Long getShoppingListId() {
            return shoppingListId;
        }

        public void setShoppingListId(Long shoppingListId) {
            this.shoppingListId = shoppingListId;
        }

        public Long getFoodItemId() {
            return foodItemId;
        }

        public void setFoodItemId(Long foodItemId) {
            this.foodItemId = foodItemId;
        }
    }

