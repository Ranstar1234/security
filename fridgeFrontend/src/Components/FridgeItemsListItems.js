import React, { useState,useEffect } from "react";
import FridgeItemDetails from "./FridgeItemDetails";
import '../Components/CurrentFridge.css'

const FridgeItemsListItems =({fridgeItem, deleteFridgeItem}) => {
    

    const [isSelected, setIsSelected] = useState(false)

    const handleDeleteFridgeItem = () => {
        deleteFridgeItem(fridgeItem.id);
    } 

    const handleViewFridgeItem = () => {
        setIsSelected(!isSelected)
    } 

    return(
    <>
     <div className="list-component">
        <div className="list-item">
       
        
            <p className="fridgeItemName">{fridgeItem.foodItem.name} </p>

            <li> Quantity: {fridgeItem.quantity} </li>
            <li> ExpiryDate: {fridgeItem.expiryDate}</li>
            

            <button className ="list-item-button" onClick= {handleViewFridgeItem}>View Item Details</button>

            <button className ="list-item-button" onClick= {handleDeleteFridgeItem}>Delete Fridge Item</button>
            <br></br>
        </div>
    </div>

    
        <div className="fridge-details">
            {isSelected?
            
            <FridgeItemDetails
            fridgeItem = {fridgeItem}
            />
            :<div></div>
    
            }
          </div>
          <hr></hr>
    </>
    
    );

}

export default  FridgeItemsListItems ;