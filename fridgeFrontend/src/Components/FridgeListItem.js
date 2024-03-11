
import './FridgeStyles.css'


const FridgeListItem =({fridge, handleFridgeNavigation, setSelectedFridge}) => {

    const handleClick = () => {
        setSelectedFridge(fridge)
        handleFridgeNavigation(fridge)
    }

    return(

    <>
    <div className="fridge-list-container">
    
    <ul>
        <button onClick={handleClick}><li>{fridge.name}</li></button>
    </ul> 
    </div>
    </>
    
    )

};

export default FridgeListItem;