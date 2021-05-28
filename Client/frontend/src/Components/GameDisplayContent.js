import React from 'react';
import '../App.css';
import ActionDisplay from "./ActionDisplay"
import TextDisplay from "./TextDisplay"

import { useDispatch, useSelector } from "react-redux"
import { changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"



export default function GameDisplayContent(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  function v(){
    const myList=props.roomActionsDesc
    const actionsList=myList.map(
      (action)=><div><ActionDisplay action={action} img={props.roomActionsImgs[props.roomActionsDesc.indexOf(action)]}/><br/></div>
    )
    return actionsList
  }


    var a= "/res/imgs/backgrounds/spidernest.jpg";
    //alert(a)
    return(
      <div id="gameDisplay" style={{ backgroundImage: "url("+store.roomBGImage+")",backgroundRepeat: 'no-repeat',
      backgroundSize:"cover"  }}>


        <TextDisplay s={props.roomDesc}/>
      {v()}
      </div>
    )




}
