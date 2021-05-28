import React from 'react';
import '../App.css';
import TextDisplay from "./TextDisplay"
import GameDisplayContent from "./GameDisplayContent"
import { useDispatch, useSelector } from "react-redux"
import {changeInventoryMessage,accessInventory,updateInventory, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility } from "../redux/mainReducerState"

export default function Inventory(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  const entered= (event) => {event.target.style.color="gold"}
  const exited= (event) => {event.target.style.color="black"}
  const clicked= (event) => {dispatch(changeInventoryMessage(""));dispatch(accessInventory(false));}
  
  const hovered= (event) => {
    var i=store.items[event.target.id];
    dispatch(changeInventoryMessage(i["name"]+": "+i["description"]));
  }

  var lists= store.inventory.map( (i) => <div><img onMouseEnter={hovered} id={i} className="inventoryImage" src={store.items[i].img}/></div> )
  //<p>{store.items[i].name}</p>
  //alert(store.items[i].name)
  //<img src={store.items[i].img}/>

  return(
  <div id="inventoryDisplay">
    {lists}
    <div><p id="inventoryText">{store.inventoryMessage}</p></div>
    <div><button onClick={clicked} onMouseEnter={entered} onMouseOut={exited} className="button">{"Exit Inventory"}</button></div>
  </div>
  )
}
