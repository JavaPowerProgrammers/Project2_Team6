import React from 'react';
import '../App.css';
import SubDisplay from "./SubDisplay"
import TextDisplay from "./TextDisplay"
import AddItemsDisplay from "./AddItemsDisplay"
import LogicContainer from "./LogicContainer"
import MiniDisplay from "./MiniDisplay"
import { useDispatch, useSelector } from "react-redux"
import {changeCombatMessageCreature, changeCombatMessage, changeTotalCombat, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"


export default function CombatSystem(props){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  const entered= (event) => {event.target.style.backgroundColor="gold"}
  const exited= (event) => {event.target.style.backgroundColor="black"}
  const clicked= (event) => {
    //changeMiniDisplay(null)
    //alert(event.target.id)
    if(event.target.id==null){return;}
    var d= store.items[event.target.id].dmg
    var s= store.items[event.target.id].statBuff
    var playerRoll=roll(d,s);
    var creatureRoll=roll(store.creatures[props.creature].dmg,null);
    var playerText="You rolled a "+playerRoll[1]+" DMG DEALT!!!";
    var creatureText="But... "+store.creatures[props.creature].name +" rolled a "+creatureRoll[1]+" DMG DEALT TO YOU:(";

    var dam= damageCalculation(playerRoll[0],creatureRoll[0])

    dispatch(changeCombatMessage(playerText))
    dispatch(changeCombatMessageCreature(creatureText))
    if(dam<=0){won();}
  }

  var weaponsList=[]
  for(var i=0;i<store.inventory.length;i++){
    if(store.items[store.inventory[i]].tag=="weapon"||store.items[store.inventory[i]].tag=="spell"){weaponsList.push(store.inventory[i])}
  }
  var lists= weaponsList.map(
    (i) => <div id={i} onClick={clicked} className="combatContainer">{([<img id={i} className="combatImage" src={store.items[i].img}/>,
    <p id={i} className="silverColor">{store.items[i].statBuff}{" "}{store.items[i].tag}{"- ("}{store.items[i].name}{"): DMG:"}<p id={i} className="redColor">{store.items[i].dmg}</p></p>,

    ])}</div>
  )

  function roll(dmg,stats){
    var l=dmg.split("d")
    var damage=0
    var damageStr=""

    for(var i=0;i<parseInt(l[0]);i++){
      var num=Math.floor(Math.random() * parseInt(l[1]));
      num=num+1;
      damageStr=(damageStr+num.toString()+",")
      damage=damage+num
    }

    if(stats!=null){
      var s=store.stats[stats]
      damage=damage+s
      damageStr=(damageStr+" + your "+stats)
      damageStr=(damageStr+" = "+damage.toString())
      return [damage,damageStr];
    }
      damageStr=(damageStr+"= "+damage.toString())
      return [damage,damageStr];
  }

  function damageCalculation(user,e){
    var playercurrentHealth=store.stats.Health
    var totalPlayerDMG=store.totalCombatDamage
    totalPlayerDMG=totalPlayerDMG+user
    playercurrentHealth=playercurrentHealth-e
    if(playercurrentHealth<=0){playercurrentHealth=0;died();return;}

    

    dispatch(changeTotalCombat(totalPlayerDMG))
    dispatch(changeHealth(playercurrentHealth))
    return (store.creatures[props.creature].health-totalPlayerDMG)
  }


  function displayHealth(){
    if(store.totalCombatDamage==0){return (<p></p>)}
    var creatureHealth=(store.creatures[props.creature].health)-(store.totalCombatDamage)
    return(
      (
        <p >{"You:    "}<img className="combatHealthIcon" src="../res/imgs/other/heart.png"/>{store.stats.Health}{" / "}{store.stats.maxHealth}
        {"    |   "}{store.creatures[props.creature].name}{": "}<img className="combatHealthIcon" src="../res/imgs/other/heart.png"/>{creatureHealth}
        {" / "}{store.creatures[props.creature].health}</p>
      )
    )
  }
  function died(){
    dispatch(changeTotalCombat(0))
    dispatch(changeCombatMessage("Choose Your Weapon:"))
    dispatch(changeCombatMessageCreature(""))
    alert("You died.")
  }
  function won(){
    dispatch(changeTotalCombat(0))
    dispatch(changeCombatMessage("Choose Your Weapon:"))
    dispatch(changeCombatMessageCreature(""))
    alert("You won.")
    dispatch(changeSubOption(1));
    dispatch(changeSubState(false));
    dispatch(changeSubContent(null));
    dispatch(changeMiniDisplay(null));
  }

  return(
  <div>
    <MiniDisplay imgName={store.currentMiniDisplay}/>
    <div className="combatMessageContainer"><p className="lightblueColor ">{store.combatMessage}</p> <p className="redColor">{store.combatMessageCreature}</p> <p>{displayHealth()}</p></div>
    {lists}
  </div>
  )
}
