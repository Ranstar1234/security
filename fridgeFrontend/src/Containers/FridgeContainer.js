import { Routes, Route, BrowserRouter, Link } from "react-router-dom";
import ShoppingList from "../Components/ShoppingList";
import Login from "../Components/Login";
import FavouriteList from "../Components/FavouriteList";
import Fridge from "../Components/currentFridge";
import NavBar from "../Components/NavBar/NavBar";
import React, { useState,useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom"

const FridgeContainer =() => {
    const [fridges, setfridges] = useState([])
    const [selectedFridge, setSelectedFridge] = useState(null);
    const [selectedFridgeItem, setSelectedFridgeItem] = useState(null)
    const [checked, setChecked] = React.useState(false);

    const [isShowAddItem, setIsShowAddItem] = useState(false);
    const handleAddItemClick =() => {
        setIsShowAddItem(!isShowAddItem);
    };

    // FRIDGE METHODS

    const fetchFridges = async () => {
        const response = await fetch("http://localhost:8080/fridges");
        const jsonFridges = await response.json();
        setfridges(jsonFridges);
    }

    const postFridge = async (newFridge, id) => {
        const response = await fetch(`http://localhost:8080/fridges`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newFridge)
        })

        const responseFridge = await response.json()
        await fetchFridges()
    }


    const deleteFridge = async (id) => {
        console.log(id);
        await fetch(`http://localhost:8080/fridges/delete/${id}`, {
            method: "DELETE",
            headers: { 'Content-Type': 'application/json' }
        });
        await fetchFridges();
    }


    // //FRIDGE LIST METHODS
    const postFridgeItem = async (newFridgeItem, fridgeId, foodItemId) => {

        const response = await fetch(`http://localhost:8080/fridges/${fridgeId}/${foodItemId}/fridgeItem`, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newFridgeItem)
        })

        const responseFridges = await response.json()
        await fetchFridges()

    }


    const deleteFridgeItem = async (id) => {
        console.log(id);
        await fetch(`http://localhost:8080/fridges/delete/foodItem/${id}`, {
            method: "DELETE",
            headers: { 'Content-Type': 'application/json' }
        });
        await fetchFridges();
        const updatedSelectedFridgeItems = selectedFridge.fridgeItems.filter((fridgeItem) => {
            return id !== fridgeItem.id 
        })
        setSelectedFridge({...selectedFridge, fridgeItems:updatedSelectedFridgeItems})
    }



    const selectFridgeItem = (fridgeItem) => {
        setSelectedFridgeItem(fridgeItem);
    }

    const Checkbox = ({ label, value, onChange }) => {
        return (
          <label>
            <input type="checkbox" checked={value} onChange={onChange} />
            {label}
          </label>
        );
      };

    //   const updateChangefridgeItemExpiryDate = (id) => {
       
    //     const response = fetch(`http://localhost:8080/fridges/fridgeItem/${foodItemId}`, {
    //         method: "POST",
    //         headers: { 'Content-type': 'application/json; charset=UTF-8' },
    //         body: JSON.stringify({expiryDate})
    //     })

    //     const responseFridges = await response.json()
    //     await fetchFridges()

    // }

    // SHOPPING LIST METHODS

    const deleteShoppingListItem = async (id) => {
        console.log(id);
        await fetch(`http://localhost:8080/fridges/shoppingList/shoppingListItem/${id}`, {
            method: "DELETE",
            headers: { 'Content-Type': 'application/json' }
        });
        await fetchFridges();
        const updatedSelectedShoppingListItems = selectedFridge.shoppingList.shoppingListItems.filter((shoppingListItem) => 
        {

            return id !== shoppingListItem.id 
        })

        console.log(updatedSelectedShoppingListItems);
        setSelectedFridge({...selectedFridge, shoppingListItems:updatedSelectedShoppingListItems})
    }






    useEffect(() => {
        fetchFridges()
    }, []);



    return(

    <>
    <NavBar handleAddItemClick = {handleAddItemClick} isShownAddItem={isShowAddItem}  Fridge={Fridge} 
    fridges = {fridges}
    deleteFridge = {deleteFridge}
    postFridgeItem = {postFridgeItem}
    deleteFridgeItem = {deleteFridgeItem}

    setSelectedFridge = {setSelectedFridge}
    selectedFridge = {selectedFridge}

    selectedFridgeItem = {selectedFridgeItem}
    selectFridgeItem = {selectFridgeItem}

    Checkbox = {Checkbox}

    checked = {checked}
    setChecked = {setChecked}

    deleteShoppingListItem = {deleteShoppingListItem} 

     />

    </>
    )

};

export default FridgeContainer;