import './CurrentFridge.css'

const FridgeItemDetails =({fridgeItem}) => {

    return(

    <>
    <div className="list-component">
        <div id = "fridge-item-details"> 
            
            <p>Food Group: {fridgeItem.foodItem.foodGroup}</p>

            <div className='updateFridgeItemButtons'>
            <button className="details-button">Change quantity</button>
            <button  className="details-button"> Change expiry Date </button>
            </div>
            <br></br>


            <p>Add to one of your lists!</p>
            <div className='addFridgeItemtoListsButtons'>
            <button  className="details-button">Add to Shopping List!</button>
            <button  className="details-button">Add to Favourites List!</button>
            </div>
         </div>
    </div> 
    </>
    
    )

};

export default FridgeItemDetails;