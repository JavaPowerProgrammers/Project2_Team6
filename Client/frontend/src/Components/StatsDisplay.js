import React from 'react';
import '../App.css';
import {useDispatch, useSelector } from "react-redux"
import { accessInventory,updateInventory, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility } from "../redux/mainReducerState"
import Inventory from "./Inventory"


export default function StatsDisplay(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  const entered= (event) => {event.target.style.color="gold"}
  const exited= (event) => {event.target.style.color="black"}
  const clicked= (event) => {dispatch(accessInventory(true));}


  function convert(stat){
    if(stat=="maxHealth"){return null}
    if(stat=="Health"){
      return <li>{stat}{": "}{store.stats[stat]}{" /"}{store.stats["maxHealth"]}</li>
    }
    return <li>{stat}{": "}{store.stats[stat]}</li>
  }

  const statsList = Object.keys(store.stats).map(convert)

  return(
        <div id="statsDisplay">
          {/*<p className="centerText  whiteColor"> Stats</p>*/}
          <ul>
            {statsList}
          </ul>
          <button onClick={clicked} onMouseEnter={entered} onMouseOut={exited} > Inventory </button>
        </div>
    )

}
