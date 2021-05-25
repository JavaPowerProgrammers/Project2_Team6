import {React, useState,} from 'react'
import '../App.css';

export const User = (props) => {
    return (
    <div>
      <div>Id: {props.user.id}</div><br/>
      <div>Name: {props.user.name}</div><br/>
      <div>Age: {props.user.age}</div><br/>
    </div>);
  };