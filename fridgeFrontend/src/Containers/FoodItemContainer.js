import React, { useState, useEffect } from "react";
import FoodItem from "../Components/FoodItem";
import NavBar from "../Components/NavBar/NavBar";


const FoodItemContainer = () => {

    const [foodItems, setFoodItems] = useState([])

    // const [isShowAddItem, setIsShowAddItem] = useState(false);
    // const handleAddItemClick = () => {
    //     setIsShowAddItem(!isShowAddItem);
    // };

    //fetching the foodItem data

    const fetchFoodItems = async () => {
        const response = await fetch("http://localhost:8080/foodItems");
        const jsonFoodItems = await response.json();
        setFoodItems(jsonFoodItems);
    }


    useEffect(() => {
        fetchFoodItems()
    }, []);

    return (

        <>
            <NavBar FoodItem={FoodItem} foodItems={foodItems} />

        </>
    )



}

export default FoodItemContainer;