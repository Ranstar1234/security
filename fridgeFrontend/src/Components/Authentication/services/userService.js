import axios from "axios";
import authHeader from "./authHeader";

const API_URL = "http://localhost:8080/users";

// const getPublicContent = () => {
//   return axios.get(API_URL + "all");
// };

const getUser = () => {
  return axios.get(API_URL , { headers: authHeader() });
};

const UserService = {
  // getPublicContent,
  getUser,
};

export default UserService;
