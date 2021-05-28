import React from 'react';
import '../App.css';
import GameDisplay from "./GameDisplay"
import NavBar from "./NavBar"
import Home from "./Home"
import About from "./About"
import Rules from "./Rules"
import { useDispatch, useSelector } from "react-redux"


export default function GameOver(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();

  return(
  <div>
  Game Over
  </div>
  )

}
