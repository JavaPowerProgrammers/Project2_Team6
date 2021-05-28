import React from 'react';
import '../App.css';
import {useDispatch, useSelector } from "react-redux"
import {setNavigation, changeCombatMessageCreature, changeCombatMessage, changeTotalCombat, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"


export default function NavBar(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  const clicked= (event) => {
    event.target.style.color="red"
  }

  return(
  <div className="navBar">

  <nav >
    <p className="whiteColor title">{<img className="navBarImage" src="./res/imgs/other/logo.png" alt=""/>}Dungeons Master</p>
  <a onClick={clicked} className="gamelink" onClick={()=>dispatch(setNavigation(0))}>Home|</a>
<a  className="gamelink" onClick={()=>dispatch(setNavigation(2))}>About|</a>
    <a  className="gamelink" onClick={()=>dispatch(setNavigation(3))}>Rules </a>

  </nav>
  
  </div>
  )
}
