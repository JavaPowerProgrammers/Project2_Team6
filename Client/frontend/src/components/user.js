import {React, useState, useEffect} from 'react'
import { Link, useHistory, useLocation} from 'react-router-dom'
import Page from '../page'
import '../App.css';

export const User = (props) => {
    return (
    <div>
      <div>Id: {props.u[0].id}</div><br/>
      <div>Name: {props.u[0].name}</div><br/>
      <div>Age: {props.u[0].age}</div><br/>
    </div>);
  };