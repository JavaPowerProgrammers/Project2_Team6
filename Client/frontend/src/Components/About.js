import React from 'react';
import '../App.css';
import { useDispatch, useSelector } from "react-redux"
import {setNavigation, changeCombatMessageCreature, changeCombatMessage, changeTotalCombat, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"

export default function About(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  return(
  <div className="gameDisplay" >
    <p className="blueColor"><br/><br/>About: DND Dungeons & Dragons (commonly abbreviated as D&D or DnD) is a fantasy tabletop role-playing game (RPG) originally designed by Gary Gygax and Dave Arneson. ... D&D departs from traditional wargaming by allowing each player to create their own character to play instead of a military formation. The main notable themes of DnD is the freeform collaborative storytelling, high fantasy world building, and incredible ability to make people addicted to buying dice, filling out paperwork, and sharing memes. 
    </p>
  </div>
  )
}
