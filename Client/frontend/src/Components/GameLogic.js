import React from 'react';
import '../App.css';
import SubDisplay from "./SubDisplay"
import TextDisplay from "./TextDisplay"
import AddItemsDisplay from "./AddItemsDisplay"
import LogicContainer from "./LogicContainer"
import CombatSystem from "./CombatSystem"
import { useDispatch, useSelector } from "react-redux"
import { changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"

export default function GameLogic(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  const args=store.logicValue;
  var returnedContent=[];
  const values=[];
  for(var i=0;i<args.length;i++){
    var temp=[]
    for(var j=0;j<args[i].length;j++){
      temp.push(args[i][j])
    }
    values.push(temp)
  }

  //Game Logic Customization
  for(var i=0;i<values.length;i++){
    var choice=values[i][0]
    values[i].shift()
    var params_temp=values[i]
    if(typeof choice=="string"){choice=parseInt(choice)}
    //Custom Functionality Choices
    switch(choice){
      case 1:// (Sub-screen Fragment (String textDisplay))
        (function subscreen(){
          var params=params_temp; //each function must begin with this.
          if(params.length>1){alert("(GameLogic.js Error)- Flavor Text Func");return;}//function's check
          returnedContent.push(<TextDisplay s={params}/>)

          //returnedContent=returnedContent.concat(params)
          //dispatch(changeSubOption(1))
          //dispatch(changeSubExitMessage("Alright"))
          //dispatch(changeSubState(true))
          //dispatch(changeSubContent(returnedContent))

          })();
        break;

      case 2:// (AddItem Fragment)
        (function additems(){
          var params=params_temp; //each function must begin with this.
          //<AddItemsDisplay s="loo"/>
          //dispatch(changeSubContent(<AddItemsDisplay/>))
          //returnedContent.push(<TextDisplay s="Funciton 2"/>)
          returnedContent.push(<AddItemsDisplay list={params[0]}/>)
          })();
        break;

      case 3:// Alter Field
      (function health(){
        var params=params_temp; //each function must begin with this.
        dispatch(changeHealth(15));

        })();

      case 4:// combat system
      (function fight(){
        var params=params_temp; //each function must begin with this.
        dispatch(changeSubOption(2))
        dispatch(changeMiniDisplay(store.creatures[params[0]].img))
        returnedContent.push(<CombatSystem creature={params[0]}/>)


        })();






    }

  }


  dispatch(changeSubState(true))
  dispatch(changeSubContent(returnedContent))




  //Logic Functions
  function addTorch(){
    var params=params_temp; //each function must begin with this.
    /*
    returnedContent=returnedContent.concat(params)
    dispatch(changeSubOption(1))
    dispatch(changeSubExitMessage("Alright"))
    var temp3=store.stats.visibility;
    temp3+=1
    dispatch(changeVisbility(temp3))
    dispatch(changeSubState(true))*/
    alert("Added torch")
    }

  //dispatch(changeSubContent(returnedContent))
  //dispatch(changeSubContent(<TextDisplay s="foooo"/>))
  //Reset Logic
  dispatch(changeLogic(false))
  dispatch(changeLogicValue(null))
  return(

    <div></div>

  )
}
