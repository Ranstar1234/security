import './CurrentFridge.css'


import ShoppingListProperties from "./ShoppingListProperties";


const ShoppingList =({fridge, checked, setChecked, Checkbox, deleteShoppingListItem }) => {
    

    return(

    <>
    <h2 className= "list-heading" ><span>Shopping List </span></h2>

    <div className="add-item-button">
        <button className="add-item" >Add Item</button>
    </div>

    <ul> 
        <ShoppingListProperties
        fridge = {fridge}
        checked = {checked}
        setChecked = {setChecked}
        checkbox = {Checkbox}
        deleteShoppingListItem = {deleteShoppingListItem} 
        />
    </ul>
    </>
    
    )

};

export default ShoppingList;