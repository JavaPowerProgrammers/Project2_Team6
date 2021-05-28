import React from 'react';
import GameLogic from "./GameLogic";
import '../App.css';
import { useDispatch, useSelector } from "react-redux"
import { changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue } from "../redux/mainReducerState"

export default function ActionDisplay(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  const entered= (event) => {
    if(store.roomActionsChosen[props.action]==true){return;}
    event.target.style.color="red"
    dispatch(changeMiniDisplay(props.img))
  }
  const exited= (event) => {
    if(store.roomActionsChosen[props.action]==true){return;}
    event.target.style.color="white"
    dispatch(changeMiniDisplay(null))
  }
  const clicked= (event) => {
    if(store.roomActionsChosen[props.action]==true){
      alert("Already chose this option.");
      return;

    }
    event.target.style.color="green"
    dispatch(changeMiniDisplay(null))
    dispatch(changeActionChoice(props.action))
    dispatch(changeLogic(true))
    dispatch(changeLogicValue(store.roomActionsLogic[props.action]))
  }
  
  return(
        <div>
          <a onClick={clicked} onMouseEnter={entered} onMouseOut={exited}>{props.action}</a>
        </div>
    )

}
