// import { Link } from "react-router-dom";
// // import ".User.css"

// const User =( {user, loggedInUser} ) => {
    
//   // const logOut = {
//   //       loggedInUser ({
//   //          name:"",
//   //           email:"",
//   //           password: "",
//   //           favLists: [] 
//   //       })
//   //       window.location.reload()
//   // }
 

//   return (
//     <>
//     <div className="user">
//       <div className="user-name">
//         <h3>Welcome {user ? user.name : ""} !</h3> 
//       </div>
//       <h3>Favourite List</h3>
//       <ul>
//         {user && user.favLists.length > 0 ? user.favLists.map(favList => {
//           return <div key = {favList.name + favList.id}>
//             <Link to={`/foodlist/${favList.id}`}> 
//             <li>{favList.name}</li>
//             </Link>
//           </div>
//         }):<li></li>}
//       </ul>
//       {/* <button onClick={logOut} id="log-out"> Log Out</button>  */}
//     </div>
    
//     </>
//   )

//   };

//   export default User;
