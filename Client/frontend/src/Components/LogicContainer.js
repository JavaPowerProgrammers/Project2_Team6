import React from 'react';
import '../App.css';
import TextDisplay from "./TextDisplay"
import GameDisplayContent from "./GameDisplayContent"
import { useDispatch, useSelector } from "react-redux"
import { changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility } from "../redux/mainReducerState"

export default function LogicContainer(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  const componentList=store.subContent.map(
    (comp)=><div>comp<br/></div>
  )

  return(
  <div>
    {componentList}

  </div>
  )
}
