package com.example.DigitalFridgeAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "fav_items")
public class FavListItem {
//    @EmbeddedId
//    @Column (name = "fav_list_item_id")
//    private FavListItemCompositeKey id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "fav_item_id")
    private Long id;
//    JOIN TO FAVOURITES
    @ManyToOne
//    @MapsId("favourites_id")
    @JsonIgnoreProperties({"favItems"})
    @JoinColumn(name = "favourites_id")
    private Favourites favourites;

    //JOIN TO FOOD ITEM
    @ManyToOne
//    @MapsId("food_item_id")
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    public FavListItem(Favourites favourites, FoodItem foodItem) {
//        this.id = new FavListItemCompositeKey(favourites.getId(), foodItem.getId());
        this.favourites = favourites;
        this.foodItem = foodItem;
    }
    public FavListItem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Favourites getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourites favourites) {
        this.favourites = favourites;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
