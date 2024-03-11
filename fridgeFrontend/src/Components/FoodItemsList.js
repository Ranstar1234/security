const FoodItemsList = ({foodItem, handleDeleteFoodItem}) => {

    // const handleDeleteFoodItem = () => {
    //     handleDeleteFoodItem(foodItem.id);
    // }

    return (
        <>
            <div className="foodItemList-list">

                <p className= "fridgeItemName"><b>Food Item: </b>{foodItem.name}</p>
                <p><b>Food Category: </b>{foodItem.foodGroup}</p>
                <button className ="list-item-button" onClick={handleDeleteFoodItem}>
                delete
                </button>
                <hr></hr>

            </div>
        </>
    )
}

export default FoodItemsList