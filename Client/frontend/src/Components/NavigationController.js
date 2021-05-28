import React from 'react';
import '../App.css';
import GameDisplay from "./GameDisplay"
import NavBar from "./NavBar"
import Home from "./Home"
import About from "./About"
import Rules from "./Rules"
import GameOver from "./GameOver"
import Initializer from "./Initializer"
import {setNavigation, useDispatch, useSelector } from "react-redux"


export default function NavigationController(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();



  if(store.navigationTag==0){
    return(
    <div><Home/></div>
    )
  }

  else if(store.navigationTag==1){

    return(
    <div><GameDisplay/></div>
    )
  }
  
  else if(store.navigationTag==2){
    return(
    <div><About/></div>
    )
  }

  else if(store.navigationTag==3){
    return(
    <div><Rules/></div>
    )
  }
  else if(store.navigationTag==4){
    return(
    <div><GameOver/></div>
    )
  }
  else if(store.navigationTag==5){
    return(
    <div><Initializer/></div>
    )
  }

  else{
    return(
      <div><Home/></div>
    )
  }

}
