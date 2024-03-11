
import React, { useState, useEffect, useContext } from "react";
import { Routes, Route, Link, BrowserRouter } from "react-router-dom";
import UserContext from './useContext';
import './App.css';
// import FridgeContainer from './Containers/FridgeContainer';
import FoodItemContainer from './Containers/FoodItemContainer';
import UserContainer from './Containers/UserContainer';
import FridgeContainer from './Containers/FridgeContainer';
import AuthService from './Components/Authentication/services/authService';
import EventBus from './Components/Authentication/common/EventBus';
import NavBar from "./Components/NavBar/NavBar";
import Home from "./Components/Authentication/loginComponents/home";
import Login from "./Components/Authentication/loginComponents/login";
import Profile from "./Components/Authentication/loginComponents/profile";
import User from "./Components/Authentication/loginComponents/user";
import Register from "./Components/Authentication/loginComponents/register";
import AddFridge from "./Components/addFridge";
import CurrentFridge from "./Components/currentFridge";
import ShoppingList from "./Components/ShoppingList";
import FavouriteList from "./Components/FavouriteList";
import FoodItem from "./Components/FoodItem";
import FridgeList from "./Components/fridgeList";
import Footer from './Components/Footer';


function App() {


  const [currentUser, setCurrentUser] = useState(undefined);
  

  // const {setLoggedInUser} = useContext(UserContext);

  //FRIDGE STATES 
  const [fridges, setfridges] = useState([])
  const [selectedFridge, setSelectedFridge] = useState(null);
  const [selectedFridgeItem, setSelectedFridgeItem] = useState(null)
  const [checked, setChecked] = React.useState(false);

  const [isShowAddItem, setIsShowAddItem] = useState(false);

  //FOODITEM STATES
  const [foodItems, setFoodItems] = useState([])
 
  //Methods

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
    }

    EventBus.on("logout", () => {
      logOut();
    });

    return () => {
      EventBus.remove("logout");
    };
  }, []);

  const logOut = () => {
    AuthService.logout();
    // set no fridge false
    setCurrentUser(undefined);
  };

  // const [loggedInUser,setLoggedInUser] = useState();
  // const [users,setUsers] = useState([]);

  // const fetchUsers = async () => {
  //   const response = await fetch('http://localhost:8080/users');
  //   const userData = await response.json();
  //   setUsers(userData);
  // }

  // const addUser = async (newUser) => { 
  //   const response = await fetch("http://localhost:8080/users", {
  //           method: "POST",
  //           headers: { 'Content-Type': 'application/json' },
  //           body: JSON.stringify(newUser)
  //       })
  //       const savedUser = await response.json();
  //       setUsers([...users, savedUser]);
  // }
  
  // useEffect(() => {
  //   fetchUsers();
  // },[])

  //FRIDGE CONTAINER ------------
  
  // FRIDGE METHODS
let requestOptions;
  if(currentUser){
  const myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${currentUser.accessToken}`);
  
  requestOptions = {
    method: 'GET',
    headers: myHeaders,
    redirect: 'follow'
  };}


  const fetchFridges = async () => {
      const response = await fetch("http://localhost:8080/fridges", requestOptions);
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
      await fetch(`http://localhost:8080/fridges/delete/${id}`
      ,{
          method: "DELETE",
          headers: { 'Content-Type': 'application/json' }
      }
      );
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

  let deleteRequestOptions;
  if(currentUser){
  const myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${currentUser.accessToken}`);
  
  deleteRequestOptions = {
    method: 'DELETE',
    headers: myHeaders,
    redirect: 'follow'
  };}
  
  const deleteFridgeItem = async (id) => {
      console.log(id);
      await fetch(`http://localhost:8080/fridges/delete/foodItem/${id}`, deleteRequestOptions
      );
      await fetchFridges();
      const updatedSelectedFridgeItems = selectedFridge.fridgeItems.filter((fridgeItem) => {
          return id !== fridgeItem.id 
      })
      setSelectedFridge({...selectedFridge, fridgeItems:updatedSelectedFridgeItems})
  }



  const selectFridgeItem = (fridgeItem) => {
      setSelectedFridgeItem(fridgeItem);
  }

  const handleAddItemClick =() => {
    setIsShowAddItem(!isShowAddItem);
};


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
      await fetch(`http://localhost:8080/fridges/shoppingList/shoppingListItem/${id}`, deleteRequestOptions);
      await fetchFridges();
      console.log(fridges[0].shoppingList.shoppingListItems)
      const updatedSelectedShoppingListItems = selectedFridge.shoppingList.shoppingListItems.filter((shoppingListItem) => 
      {

          return id !== shoppingListItem.id 
      })

      console.log(updatedSelectedShoppingListItems);
      const innerShoppingList = {...selectedFridge.shoppingList}
      innerShoppingList.shoppingListItems = updatedSelectedShoppingListItems
      setSelectedFridge({...selectedFridge, shoppingListItems:updatedSelectedShoppingListItems,
      shoppingList:innerShoppingList})
  }


  useEffect(() => {
      fetchFridges()
  }, [currentUser]);

//FOODITEM METHODS

    // const [isShowAddItem, setIsShowAddItem] = useState(false);
    // const handleAddItemClick = () => {
    //     setIsShowAddItem(!isShowAddItem);
    // };

    //fetching the foodItem data

    const fetchFoodItems = async () => {
        const response = await fetch("http://localhost:8080/foodItems", requestOptions);
        const jsonFoodItems = await response.json();
        setFoodItems(jsonFoodItems);
    }


    useEffect(() => {
        fetchFoodItems()
    }, [currentUser]);

  
  return (
    <> 

  <BrowserRouter>
        <div className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            DigitalFridge
          </Link>
          <div className="navbar-nav mr-auto">


            {currentUser && (
              <li className="nav-item">
              
    
                  

            </li>

          )}
        </div>

        {currentUser ? (
          <div className="navbar-nav">
            <li className="nav-item">
              <Link to={"/profile"} className="nav-link">
                {currentUser.username}
              </Link>
            </li>
            <li className="nav-item">
              <Link to ="/login" className="nav-link" onClick={logOut}>
                LogOut
              </Link>
            </li>
            
            {/* <li><Link to = '/AddFridge' className="link">Add Fridge</Link></li>  */}
            <li><Link to = '/CurrentFridge' className="link">Current Fridge</Link></li>
            <li><Link to = '/ShoppingList' className="link">Shopping List</Link></li>
            <li><Link to = '/FavouriteList' className="link">Favourites</Link></li>
            <li><Link to='/FoodItem' className="link">Food List</Link></li>
            <li><Link to = '/fridgeList' className="link">Fridges</Link></li>
            
          </div>
        ) : (
          <div className="navbar-nav ml-auto">
            <li className="nav-item">
              <Link to={"/login"} className="nav-link">
                Login
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/register"} className="nav-link">
                Sign Up
              </Link>
            </li>
          </div>
        )}
      </div>

      <div className="container mt-3">
        <Routes>
          
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/profile" element={<Profile/>} />

        <Route path="/addfridge" element={<AddFridge />} />
        <Route path="/currentfridge" element={<CurrentFridge 
            fridge = {selectedFridge}
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
        />}/>
        <Route path="/favouriteList" element={<FavouriteList />}/>

        <Route path="/FoodItem" element={<FoodItem foodItems={foodItems} FoodItem={FoodItem}/>} />

        <Route path="/fridgeList" element={<FridgeList
        fridges = {fridges} 
        deleteFridge = {deleteFridge} 
        setSelectedFridge = {setSelectedFridge}
        selectedFridge = {selectedFridge}
        />} />
          
        </Routes>
      </div>

    </BrowserRouter>


    </>
  
     
  );
}

export default App;
      
    

 
     {/* <UserContext.Provider value={{loggedInUser, users,setLoggedInUser}} >
        {loggedInUser ? 
        <FridgeContainer /> :   
        <UserContainer  register={addUser} />}
        
     

      UserContext.Provider>  */}

 {/* put <BrowserRoute> inside here*/}

{/* 
    useContxt for if statement

      see usr container (login) first
      if sucessfully logged --> fridge container
                               if assigned to a fridge ---> access to all pages
                              else---> only access to addFridge & favList & logout --> usecontainer once clciked on logout */}
    {/* <FridgeContainer /> */}
    {/* <FoodItemContainer/> */}
      {/* <usecontext>  */}
  
    
    