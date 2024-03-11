import { useNavigate, useParams } from "react-router-dom"
import { useState } from "react";
import FridgeListItem from "./FridgeListItem";
import './FridgeStyles.css'


const FridgeList =({fridges , setSelectedFridge, selectedFridge}) => {

    const navigate = useNavigate();
    
    
    const handleFridgeNavigation = (fridge) => {
        navigate(`/CurrentFridge`)
    }


    const fridgeOptions = fridges.map((fridge, index) => {
        return <FridgeListItem
           fridge= {fridge}
           key= {index}
           handleFridgeNavigation = {handleFridgeNavigation}
           setSelectedFridge = {setSelectedFridge}
           />
        
        })



    return(

        <>

        <div className="fridge-top-container">
                <hr className="top-hr"/>
         <h2>All Available Fridges</h2>

         <hr />
            </div>
            <div className="fridge-middle-container">


         <section> 
        <h2>Please select a fridge:</h2> 
        </section>
       
        </div>
            <ul>
            {fridgeOptions} 
            </ul>

        
        </>
    )
}

export default FridgeList;