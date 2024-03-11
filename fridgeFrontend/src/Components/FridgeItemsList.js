import FridgeItemsListItems from "./FridgeItemsListItems";
import './CurrentFridge.css'

const FridgeItemsList =({fridge, deleteFridgeItem, selectFridgeItem }) => {

    const fridgeListItems = fridge.fridgeItems.map((fridgeItem)=>{
    
            return <FridgeItemsListItems
                    fridgeItem={fridgeItem} 
                    deleteFridgeItem = {deleteFridgeItem}
                    selectFridgeItem ={selectFridgeItem}
                    key = {fridgeItem.id}
               />
        })
        

    return(
    <>
    <h3 className= "current-fridge-heading"> {fridge.name}</h3>
    <div className="items-card">
    {fridgeListItems}
    </div>
    </>
    
    )

};
export default  FridgeItemsList;