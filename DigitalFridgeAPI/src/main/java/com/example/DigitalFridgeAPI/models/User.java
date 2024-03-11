package com.example.DigitalFridgeAPI.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(unique = true) // ensuring only unique username is allowed
    private String username;

    @NotBlank
    @Column
    private String password;

    @NotBlank
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favourites_id", referencedColumnName = "id")
//    @JsonIgnoreProperties({"users"})
    private Favourites favourites;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name ="users_fridges",
            joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name="fridge_id",nullable = false)}
        )
//    @JsonIgnoreProperties({"users"})
    private List<Fridge> userFridges;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.favourites = null;
        this.userFridges= new ArrayList<>();
    }

    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Favourites getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourites favourites) {
        this.favourites = favourites;
    }

    public List<Fridge> getUserFridges() {
        return userFridges;
    }

    public void setUserFridges(List<Fridge> userFridges) {
        this.userFridges = userFridges;
    }
    public void addFridge(Fridge fridge){
        this.userFridges.add(fridge);}


}
