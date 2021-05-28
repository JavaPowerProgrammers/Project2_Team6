import React from 'react';
import '../App.css';
import TextDisplay from "./TextDisplay"
import GameDisplayContent from "./GameDisplayContent"
import { useDispatch, useSelector } from "react-redux"
import { changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility } from "../redux/mainReducerState"

export default function SubDisplay(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  const entered= (event) => {event.target.style.color="gold"}
  const exited= (event) => {event.target.style.color="black"}
  const clicked= () => {dispatch(changeSubState(false)); dispatch(changeSubContent(null)); changeMiniDisplay(null);}

  //Supporting Conditional Rendering Functions
  function generateItems(list){

  }



  if(store.subOption==1){ // Just Display text w/ Button
    return(
    <div>
      <div id="subDisplay">
        {store.subContent}
        <div><button onClick={clicked} onMouseEnter={entered} onMouseOut={exited} className="button">{props.message}</button></div>
      </div>
    </div>
    )
  }

  else if(store.subOption==2){ // Conditional-No Button
    return(
    <div>
      <div id="subDisplay">
        {store.subContent}
        <div></div>
      </div>
    </div>
    )
  }

  else{// Just Open Blank Screen
  return(
  <div>
    <div id="subDisplay">
      <div><button onClick={clicked} onMouseEnter={entered} onMouseOut={exited} className="button">{props.message}</button></div>
    </div>
  </div>
  )
  }
}
