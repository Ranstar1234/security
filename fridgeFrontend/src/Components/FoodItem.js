import FoodItemsList from "./FoodItemsList";
import { React } from "react"
import "./Style.css";
import { useState } from 'react';



const FoodItem = ({ handleAddItemClick, isShownAddItem, foodItems, deleteFoodItem, selectFoodItem }) => {

    const handleClick = () => {
        handleAddItemClick();
    };

    const [stateFoodItem, setStateFoodItem] = useState(
        {
            name: "",
            foodGroup: null
        }
    )

    // const handleChange = (event) => {
    //     let propertyName = event.target.name; 
    //     let copiedFoodItem = {...stateFoodItem}
    //     copiedFooodItem[propertyName] = event.target.value;
    //     setStateFoodItem(copiedFoodItem);
    // }

    


    const foodItemsListComponent = foodItems.map((foodItem, selectFoodItem) => {
        return <FoodItemsList
            key={foodItem.id}
            foodItem={foodItem}
            deleteFoodItem={deleteFoodItem}
            selectFoodItem={selectFoodItem}
        />
    })

    // const foodGroupOptions = foodGroup.map((foodGroup) => {
    //     return <option value={foodGroup}>{foodGroup}</option>
    // })

    const handleFormSubmit = (event) => {
        event.preventDefault()
    }

    return (

        <>
            <br />
            <br />

            {/* <div className="foodItem-title-container"> */}
                <div className= "list-heading" > 
                <h1>Food List</h1>
            </div>

            <div className='foodItem-content'>

            <div className="searchBar-wrap">
                <form>
                    <input type="text" placeholder="Search..." />
                    <button type="submit">Search</button>
                </form>
            </div>

                <button onClick={handleClick} className="addItemIcon">Add New Item</button>

                <div className={`${isShownAddItem ? "active show" : "hidden"} `}>
                    <div className="food-form">
                        <div className="form-box">
                            <form onSubmit={handleFormSubmit}>
                                <h3>Add Item</h3>

                                <input
                                    type="text"
                                    placeholder="Enter name"
                                    name="name"
                                // onChange={handleChange}
                                // value={stateFoodItem.name} 
                                />

                                <select
                                    name="foodGroup"
                                    defaultValue="select-foodGroup">
                                    <option disabled-value="select-foodGroup">Select Category</option>
                                </select>

                                <button type="submit">Add</button>
                            </form>

                        </div>

                    </div>
                </div>


            </div>


            <ul>
            <div className="items-card">
                {foodItemsListComponent}
                </div>
            </ul>
        </>

    )

};

export default FoodItem;