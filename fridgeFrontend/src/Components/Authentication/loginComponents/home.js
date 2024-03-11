import React, { useState, useEffect } from "react";

import UserService from "../services/userService";

const Home = () => {
  // const [content, setContent] = useState(""); // render user information with error message

  // useEffect(() => {
  //   UserService.getPublicContent()
  //   .then(
  //     (response) => {
  //       setContent(response.data);
  //     },
  //     (error) => {
  //       const _content =
  //         (error.response && error.response.data) ||
  //         error.message ||
  //         error.toString();

  //       setContent(_content);
  //     }
  //   );
  // }, []);

  return (
    // <div className="container">
    //   <header className="jumbotron">
    //     <h3>{content}</h3> 
    //   </header>
    // </div>
    <p><b>login first</b> to access all other pages</p>
  );
};

export default Home;
