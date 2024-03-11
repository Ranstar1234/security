import React, { useState, useEffect, useContext } from "react";
import { Routes, Route, Link, BrowserRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import AuthService from "../Components/Authentication/services/authService";
import Login from "../Components/Authentication/loginComponents/login";
import Register from "../Components/Authentication/loginComponents/register";
import Home from "../Components/Authentication/loginComponents/home";
import Profile from "../Components/Authentication/loginComponents/profile";
import User from "../Components/Authentication/loginComponents/user";
import EventBus from "../Components/Authentication/common/EventBus";
import UserContext from "../useContext";
import NavBar from "../Components/NavBar/NavBar";


// const UserContainer = ( {addUser}) => {
  // no fridge false
  // const [currentUser, setCurrentUser] = useState(undefined);

  // // const {setLoggedInUser} = useContext(UserContext);

  // useEffect(() => {
  //   const user = AuthService.getCurrentUser();

  //   if (user) {
  //     setCurrentUser(user);
  //   }

  //   EventBus.on("logout", () => {
  //     logOut();
  //   });

  //   return () => {
  //     EventBus.remove("logout");
  //   };
  // }, []);

  // const logOut = () => {
  //   AuthService.logout();
  //   // set no fridge false
  //   setCurrentUser(undefined);
  // };

  // return (
    
  //   <BrowserRouter>
  //     <div className="navbar navbar-expand navbar-dark bg-dark">
  //       <Link to={"/"} className="navbar-brand">
  //         DigitalFridge
  //       </Link>
  //       <div className="navbar-nav mr-auto">
  //         <li className="nav-item">
  //           <Link to={"/home"} className="nav-link"> 
  //             Home
  //           </Link>
  //         </li>


  //         {currentUser && (
  //           <li className="nav-item">
  //             <Link to={"/user"} className="nav-link">
  //               User
  //             </Link>
  //           </li>

  //         )}
  //       </div>

  //       {currentUser ? (
  //         <div className="navbar-nav ml-auto">
  //           <li className="nav-item">
  //             <Link to={"/profile"} className="nav-link">
  //               {currentUser.username}
  //             </Link>
  //           </li>
  //           <li className="nav-item">
  //             <Link to ="/login" className="nav-link" onClick={logOut}>
  //               LogOut
  //             </Link>
  //           </li>
  //           <li>
  //             <NavBar />
  //           </li>
  //         </div>
  //       ) : (
  //         <div className="navbar-nav ml-auto">
  //           <li className="nav-item">
  //             <Link to={"/login"} className="nav-link">
  //               Login
  //             </Link>
  //           </li>

  //           <li className="nav-item">
  //             <Link to={"/register"} className="nav-link">
  //               Sign Up
  //             </Link>
  //           </li>
  //         </div>
  //       )}
  //     </div>

  //     <div className="container mt-3">
  //       <Routes>
  //         <Route path="/" element={<Home/>} />
  //         <Route path="/home" element={<Home/>} />
  //         <Route path="/login" element={<Login/>} />
  //         <Route path="/register" element={<Register/>} />
  //         <Route path="/profile" element={<Profile/>} />
  //         <Route path="/user" element={<User/>} />
  //       </Routes>
  //     </div>

  //   </BrowserRouter>
  // );
// };

// export default UserContainer;
