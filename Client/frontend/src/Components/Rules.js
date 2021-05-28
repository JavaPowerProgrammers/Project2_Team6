import React from 'react';
import '../App.css';
import { useDispatch, useSelector } from "react-redux"
import {setNavigation, changeCombatMessageCreature, changeCombatMessage, changeTotalCombat, changeText, changeMiniDisplay, changeActionChoice, changeLogic, changeLogicValue, changeSubState, changeSubOption, changeSubContent, changeSubExitMessage,changeHealth,changeVisbility} from "../redux/mainReducerState"

export default function Rules(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  return(
  <div className="gameDisplay" >
    <p className="blueColor"><br/><br/>"Rules: Ruleset of DnD
While this game is not an exact replica of DnD, it is heavily inspired by it. We have created a type of decision-based dungeon crawler game modelled heavily but not fully, off the typical DnD ruleset. When you click play, you will choose your dungeon, Race (Elf, Dwarf, Human), and Class (Rogue, Fighter, Wizard). Based on your choices, you will have different attributes (Strength, Dexterity, Constitution, Wisdom, Charisma, Intelligence) and based on those attributes, you will be better or worse at different actions. Do your prioritize dexterity to dodge traps, or wisdom to spot them? Do you choose strength to empower your weapon swings, or intelligence to enhance your spells? Your decisions affect your journey. Due to the random nature of dice, no 2 journeys will be exactly the same, even if you make the same choices. So, hop on in, click play, and pray that the dice gods and RNGesus smile upon you.
Credits: David Houman, Rakeon Jerralds, Benjamin Bales"
    </p>
  </div>
  )
}
