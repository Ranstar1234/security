import './CurrentFridge.css'


const ShoppingListItems =({shoppingListItem, checked, setChecked,Checkbox, deleteShoppingListItem}) => {

    const handleChange = () => {
        setChecked(!checked);
    }

    const handleDeleteShoppingListItem = () => {
        deleteShoppingListItem(shoppingListItem.id);
    } 

    return(

    <>
    <p className="fridgeItemName"> {shoppingListItem.foodItem.name}</p>
    <p>Quantity: {shoppingListItem.quantity}</p>
    <p>Shop: {shoppingListItem.shop} </p>

    <button className ="list-item-button" onClick= {handleDeleteShoppingListItem}>Delete Shopping List Item</button>
    <br></br>
    
    
     <div >
        <label className="checkbox-component">
      <input type="checkbox" 
       checked = {checked}
       onChange={handleChange}
      /><span class="checkmark"></span>

      
      </label>

      <hr></hr>
    </div>
    </>
    
    )

};

export default ShoppingListItems;