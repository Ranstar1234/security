// ignore_for_file: prefer_const_constructors

import axios from "axios";

const API_URL = "http://localhost:8080/auth"; //user path

const register = (username, email, password) => {//register -- post
  return axios.post(API_URL + "/signup", {
    username,
    email,
    password,
  });
};

const login =   (username, password) => { //login -- post 
  return axios
    .post(API_URL + "/signin", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.accessToken) {
        localStorage.setItem("users", JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("users");
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("users"));
};

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;
