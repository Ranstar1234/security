
const AddFridgeItemForm =({foodItems}) =>{


    // const foodItemOptions = FoodItems.map((foodItem) => {
    //     return <>
    //     <option key={foodItem.id} value={foodItem.id}>{foodItem.name}</option>
    //     </>
    // })

    // const handleItemChange = (event) => {
    //     let screenCapacity = event.target.name;
    //     let copiedScreen = { ...stateScreen }
    //     copiedScreen[screenCapacity] = event.target.value;
    //     setStateScreen(copiedScreen);
    // }

    // const handlePostFridgeItem = (event) => {
    //     event.preventDefault()
    //     postScreen(stateScreen, cinema.id)
    // }

    // return(

    // <>
    // <h4>Add New form</h4>
    
    //     <div className="postFridgeItem">
    //                     <form onSubmit={handlePostFridgeItem}>
    //                         <h3>Add a new </h3>
    //                         <label htmlFor="Food Item">Find your Item</label>
    //                         <input
    //                             type="text"
    //                             placeholder="Enter Screen Capacity"
    //                             name="capacity"
    //                             onChange={handleItemChange}
    //                             value={stateScreen.capacity}
    //                         />

    //                         <label htmlFor="enter length">Enter length: </label>
    //                         <input
    //                             type="text"
    //                             placeholder="Enter Length"
    //                             name="length"
    //                             onChange={handleMovieChange}
    //                             value={cinema.movies.runTime}
    //                         />
    //                         <br></br>
    //                         <label htmlFor="enter releaseDate">Enter Release Date: </label>
    //                         <input
    //                             type="text"
    //                             placeholder="Enter Release Date"
    //                             name="releaseDate"
    //                             onChange={handleMovieChange}
    //                             value={cinema.movies.releaseDate}
    //                         />


    //                         <button type="submit">Add</button>
    //                     </form>
    //                 </div>



    // </>
    
    // )

};

export default AddFridgeItemForm;