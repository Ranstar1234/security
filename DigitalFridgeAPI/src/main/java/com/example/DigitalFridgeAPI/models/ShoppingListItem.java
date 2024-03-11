package com.example.DigitalFridgeAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



    @Entity(name = "shopping_list_items")
    public class ShoppingListItem {

//        @EmbeddedId
//        @Column (name = "shopping_list_item_id")
//        private ShoppingListItemCompositeKey id;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "shopping_list_item_id")
        private Long id;


        //JOIN TO SHOPPING LIST
        @ManyToOne
//        @MapsId("shopping_list_id")
        @JsonIgnoreProperties({"shoppingListItems"})
        @JoinColumn(name = "shopping_list_id")
        private ShoppingList shoppingList;

        //JOIN TO FOOD ITEM
        @ManyToOne
//        @MapsId("food_item_id")
        @JoinColumn(name = "food_item_id")
        private FoodItem foodItem;

        //ADDITIONAL PROPERTIES
        @Column(name = "quantity")
        private Integer quantity;
        @Column(name = "shop")
        private String shop;

        //CONSTRUCTOR

        public ShoppingListItem(ShoppingList shoppingList, FoodItem foodItem, Integer quantity, String shop) {
//            this.id = new ShoppingListItemCompositeKey(shoppingList.getId(), foodItem.getId());
            this.shoppingList = shoppingList;
            this.foodItem = foodItem;
            this.quantity = quantity;
            this.shop = shop;
        }

        public ShoppingListItem() {
        }

//        public ShoppingListItemCompositeKey getId() {
//            return id;
//        }
//
//        public void setId(ShoppingListItemCompositeKey id) {
//            this.id = id;
//        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ShoppingList getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(ShoppingList shoppingList) {
            this.shoppingList = shoppingList;
        }

        public FoodItem getFoodItem() {
            return foodItem;
        }

        public void setFoodItem(FoodItem foodItem) {
            this.foodItem = foodItem;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getShop() {
            return shop;
        }

        public void setShop(String shop) {
            this.shop = shop;
        }
    }

