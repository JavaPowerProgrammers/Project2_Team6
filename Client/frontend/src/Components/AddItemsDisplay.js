import React from 'react';
import '../App.css';
import TextDisplay from "./TextDisplay"
import GameDisplayContent from "./GameDisplayContent"
import { useDispatch, useSelector } from "react-redux"
import { updateInventory, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility } from "../redux/mainReducerState"

export default function AddItemsDisplay(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  const entered= (event) => {event.target.style.color="gold"}
  const exited= (event) => {event.target.style.color="black"}
  const clicked= (event) => {
    var add=store.inventory.slice()
    add.push(event.target.id)
    dispatch(updateInventory(add))
    event.target.style.display="none"
  }

  const componentList=props.list.map(
    (comp)=><div className="item">{
      ([<img className="itemImage" src={store.items[comp].img} alt={"[Item]"}/>,
      <p className="silverColor">{store.items[comp].name}{":"}</p>,<p className="leftText">{store.items[comp].description}</p>,
      <button id={comp} onClick={clicked} onMouseEnter={entered} onMouseOut={exited}>Add to inventory</button>])
      
      }</div>
  )
  //<img id={"itemImage"} src={store.items[comp].img} alt={"[Item]"}/>
  //store.items[comp].name

  return(
  <div>
    {componentList}
  </div>
  )
}
