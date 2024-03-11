import React from "react"
import { Routes, Route, BrowserRouter, Link } from "react-router-dom";
import ShoppingList from "../ShoppingList";
import FavouriteList from "../FavouriteList";
import CurrentFridge from "../currentFridge";
import "./NavBar.css";
import AddFridge from "../addFridge";

import FridgeList from "../fridgeList";
import FoodItem from "../FoodItem";

const NavBar = ({ handleAddItemClick ,isShownAddItem, fridges, deleteFridge,
  postFridgeItem, deleteFridgeItem,
  setSelectedFridge, selectedFridge,selectedFridgeItem,
  selectFridgeItem, checked, setChecked, Checkbox, deleteShoppingListItem }) => {
    const handleClick = () => {
      handleAddItemClick();
    };

    // const categoryOptions = categories ? categories.map((category) => {
    //   return <option key={category.categoryid}>{category}</option>
    // }); 
    // category option tag


    return (
    <>  


     <nav className="navbar">
        <div className="nav-links">
        <ul className="menu">
          
            {/* <li><Link to = '/AddFridge' className="link">Add Fridge</Link></li> 
            <li><Link to = '/CurrentFridge' className="link">Current Fridge</Link></li>
            <li><Link to = '/ShoppingList' className="link">Shopping List</Link></li>
            <li><Link to='/FoodItem' className="link">Food List</Link></li>
            <li><a href="user profile" className="link">User</a>
            <ul className="dropdown">
                <li><Link to = '/fridgeList' className="link">Fridges</Link></li>
                <li><Link to = '/FavouriteList' className="link">Favourites</Link></li>
                <li><Link to = '/login' className="link">Log Out</Link></li>
            </ul>
            </li> */}
            <li>
          <span onClick={handleClick} className="additemicon">
            Add Item
          </span>
        </li>

        <div className={`${isShownAddItem ? "active show" : "hidden"} `}>
        <div className="food-form">
        <div className="form-box"> 
          <form>
            <h1 className="additem-text">Add Item</h1>
            <br/>
            <label className="additem-box">Food Name</label>
            <br></br>
            <input type="text" name="foodname" className="additem-box" />
            <label className="additem-text">Category</label> 
            {/* Using option tag to enable Category choose */}
            <br></br>
            <input type="text"  className="additem-box" />
            {/* <select> <option> select category </option> </select>*/ }
            <br></br>
            <input type="submit" value="Add now" className="additem-btn" />
          </form>
        </div>
      </div>
    </div>
    
    </ul>
    </div>
   </nav>
   {/* <BrowserRouter>

        <Routes>
        <Route path="/addfridge" element={<AddFridge />} />

        <Route path="/currentfridge" element={<CurrentFridge fridge = {selectedFridge}
            postFridgeItem = {postFridgeItem}
            deleteFridgeItem = {deleteFridgeItem}
            selectedFridgeItem = {selectedFridgeItem}
            selectFridgeItem = {selectFridgeItem}


     />}/>
        <Route path="/ShoppingList" element={<ShoppingList 
          fridge = {selectedFridge} 
          checked = {checked} 
          setChecked = {setChecked}
          Checkbox = {Checkbox}
          deleteShoppingListItem = {deleteShoppingListItem} 
          />}
          
          />

        <Route path="/favouriteList" element={<FavouriteList />}/>

        <Route path="/favouriteList" element={<FavouriteList />}/>
        <Route path="/foodItem" element={<FoodItem foodItems={foodItems} />} />
        <Route path="/fridgeList" element={<FridgeList/>} />
        

        <Route path="/fridgeList" element={<FridgeList fridges = {fridges} 
            deleteFridge = {deleteFridge} 
            setSelectedFridge = {setSelectedFridge}
            selectedFridge = {selectedFridge}
        />} />

    </Routes>

    </BrowserRouter> */}

    
        </>
     
    );
  }
  export default NavBar;