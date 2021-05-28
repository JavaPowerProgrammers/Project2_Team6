import React from 'react';
import '../App.css';

export default function MiniDisplay(props){
  if(props.imgName==null){return null}
  return(<img id={"miniDisplayImage"} src={props.imgName} alt={"[Image]"}/>)
}
