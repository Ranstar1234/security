// import React from "react";
// import { useState } from "react";
// import { useNavigate } from "react-router-dom";


// const Login =({users, loggedInUser, postUser})=> {
//     const navigate = useNavigate();

//     const [details, setDetails] = useState({name: "", email: "", password: "",favList:[]});
    
//     const handleChange = event => {//will be replaced by authe for user login setup
//         const userId = parseInt(event.target.value);
//     }

//     const handleFormSubmit = event => { //auth might replace
//         event.preventDefault();
//         loggedInUser(details);
//     }
// tutorial login setup 
    // const login = details=> { //
    //     console.log(details);
    
    //     if (details.email == adminUser.email && details.password == adminUser.password)
    //       console.log("Logged in");
    //       setUser({
    //         name: details.name,
    //         email: details.email
    //       });
    
    //   } else {
        
    //     console.log("details not found");
    //     setError("details not found");// user detail not match
    //   };
    
    //   const Logout = () => {
    //     console.log("Logout");
    //   }

    //   const [user, setUser] = useState({name:"", email: "", password:""});//user chosen
    //   const [error, setError] = useState("");

     
    //   const handleRegisterChange = event => {
        // const propertyName = event.target.name
        // const savedUser = {...newUser}
        // savedUser [propertyName] = event.target.value
        // setNewUser(savedUser)
    //   }

    // return(
    //     <>
    
    //     <form onSubmit={submitHandler}>
    //         <div className="form-inner">
    //             <h2>Login</h2>
    //             {/* error! */}
    //             <div className="form-group">
    //                 <label htmlFor="name">Name:</label>
    //                 <input type="text" name="name" id="name" onChange={e => setDetails({...details, name: e.target.value})} value ={details.name} />

    //             </div>
    //             <div className="form-group">
    //             <label htmlFor="email">Email: </label>
    //             <input type="email" name="email" id="email" onChange={e => setDetails({...details, email: e.target.value})} value ={details.email} />
    //             </div>
    //             <div className="form-group">
    //             <label htmlFor="password">Password: </label>
    //             <input type="password" name="password" id="password" onChange={e => setDetails({...details, password: e.target.value})} value ={details.password} />
    //             </div>
    //             <input type="submit" value="Login"/>

    //         </div>
    //     </form>
    //     </>
    // )

// };

// export default Login;