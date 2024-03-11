//package com.example.DigitalFridgeAPI.models;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//
//@Embeddable
//public class FavListItemCompositeKey implements Serializable {
//
//        @Column(name = "favourites_id")
//        Long favouritesId;
//
//        @Column(name = "food_item_id")
//        Long foodItemId;
//
//        public FavListItemCompositeKey(Long favouritesId, Long foodItemId) {
//                this.favouritesId=favouritesId;
//                this.foodItemId = foodItemId;
//        }
//
//        public FavListItemCompositeKey(){}
//        public Long getFavouritesId() {
//                return favouritesId;
//        }
//
//        public void setFavouritesId(Long favouritesId) {
//                this.favouritesId = favouritesId;
//        }
//
//        public Long getFoodItemId() {
//                return foodItemId;
//        }
//
//        public void setFoodItemId(Long foodItemId) {
//                this.foodItemId = foodItemId;
//        }
//
//}
