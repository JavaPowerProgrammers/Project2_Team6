import React from 'react';
import '../App.css';

export default function TextDisplay(props){
  return(
    <div>
      <p className={"font1"}>{props.s}</p>
      <br/>
    </div>
  )
}
