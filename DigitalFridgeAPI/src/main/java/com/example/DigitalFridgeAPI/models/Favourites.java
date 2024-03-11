package com.example.DigitalFridgeAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name="favourites")
public class Favourites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "favourites",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"favourites"})
    List<FavListItem> favItems;

    @OneToOne(mappedBy = "favourites")
    private User user;

    public Favourites( String name, User user) {
        this.name = name;
        this.user = user;
        this.favItems = new ArrayList<>();
//        this.shoppingList = new ArrayList<>();
//        this.fridgeList = new ArrayList<>();

    }

    public Favourites() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public List<FavListItem> getFavItems() {
        return favItems;
    }

    public void setFavItems(List<FavListItem> favItems) {
        this.favItems = favItems;
    }

}

