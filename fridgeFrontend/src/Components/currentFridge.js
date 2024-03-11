import { useState, React } from "react"
import { useParams } from "react-router-dom"
import FridgeItemDetails from "./FridgeItemDetails";
import FridgeItemsList from "./FridgeItemsList";
import AddFridgeItemForm from "./AddFridgeItemForm";
import './CurrentFridge.css'

const CurrentFridge =({fridge, postFridgeItem,
    deleteFridgeItem, setSelectedFridge, selectedFridge, selectFridgeItem, selectedFridgeItem }) => {


        const [isAddSelected, setIsAddSelected] = useState(false)    

    const fridgeListItems = (
        <FridgeItemsList 
                    fridge={fridge} 
                    postFridgeItem = {postFridgeItem}
                    deleteFridgeItem = {deleteFridgeItem}
                    selectedFridgeItem = {selectedFridgeItem}
                    selectFridgeItem = {selectFridgeItem}
                />
    )

    

    const fridgeItemDetails = 
    <FridgeItemDetails
    selectedFridgeItem = {selectedFridgeItem}
    /> 
   
        // POST NEW ITEM METHOD
        //   const handlePostFridgeItem = (event) => {
        //         event.preventDefault()
        //         postFridgeItem(fridge.id, foodItem.id)
        //     }

        const handleViewAddForm = () => {
            setIsAddSelected(!isAddSelected)
        } 

            

    return(

    <>

    <h2 className= "list-heading"><span>Fridge</span></h2>

    <div className="add-item-button">
        <button className="add-item" onClick= {handleViewAddForm}>Add Item</button>
    </div>

     {isAddSelected?
       <AddFridgeItemForm
       />
       :<div></div>
    
            }



    <ul>
        {fridgeListItems}
    </ul>

    

    
    </>
    
    )

};

export default CurrentFridge;