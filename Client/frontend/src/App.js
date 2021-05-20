import {React, useState, useEffect} from 'react'
import { Link, useHistory, useLocation} from 'react-router-dom'
import Page from './page'
import './App.css';
import axios from 'axios';

export default function App() {
const [acidArrow, setAcidArrow] = useState(undefined);
// const [name, setName] = useState("");
// const [description, setDescription] = useState("");
// const [level, setLevel] = useState("");
const history = useHistory();
// const location = useLocation();


useEffect( ()=> {
  if(acidArrow !== undefined){
    console.log("acidArrow", acidArrow);
  }
}, [acidArrow, history]);

const getAcidArrow = (e) => {
  e.preventDefault();
  axios.get('https://www.dnd5eapi.co/api/spells/acid-arrow/')
  .then( res => {
      setAcidArrow(res.data);
  });
}

const AcidArrow = (props) => {
  return (
  <div>
    <div>Index: {props.a.index}</div><br/>
    <div>Name: {props.a.name}</div><br/>
    <div>Description: { props.a.desc}</div><br/>
    <div>Higher Level: {props.a.higher_level}</div><br/>
    <div>Range: {props.a.range}</div><br/>
    <div>Components: {props.a.components}</div><br/>
    <div>Material: {props.a.material}</div><br/>
    <div>Ritual: {props.a.ritual.toString()}</div><br/>
    <div>Duration: {props.a.duration}</div><br/>
    <div>Concentration: {props.a.concentration.toString()}</div><br/>
    <div>Casting Time: {props.a.casting_time}</div><br/>
    <div>Level: {props.a.level}</div><br/>
    <div>Attack Type: {props.a.attack_type}</div><br/>
    {/* <div>Damage: {props.a.damage}</div><br/> */}
    {/* <div>School: {props.a.school}</div><br/>
    <div>Classes: {props.a.classes}</div><br/>
    <div>Subclasses: {props.a.subclasses}</div><br/> */}
    <div>URL: {props.a.url}</div><br/>
  </div>);
};

  return (
    <div className="App">
      <header className="App-header">
        <p>
          <div><button onClick={getAcidArrow}> Acid Arrow</button></div>
          {acidArrow && <AcidArrow a={acidArrow} />}
        </p>
      </header>
    </div>
  );
}