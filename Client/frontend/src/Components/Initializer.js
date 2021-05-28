import React from 'react';
import '../App.css';
import { useDispatch, useSelector } from "react-redux"
import {setNavigation, changeCombatMessageCreature, changeCombatMessage, changeTotalCombat, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"


export default function Initializer(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  return(
  <div >
    <br/>
    <br/>
    <button className="button" onClick={()=>dispatch(setNavigation(1))}> Duegon 1 </button>
  </div>
  )
}
