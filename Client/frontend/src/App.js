import {React, useState, useEffect} from 'react'
import './App.css';
import axios from 'axios';
import {AcidArrow} from './components/acidarrow';
import {Dagger} from './components/dagger'
import {DancingLights} from './components/dancinglights'
import {BurningHands} from './components/burninghands'

export default function App() {
const [daggers, setDaggers] = useState(undefined);
const [acidArrows, setAcidArrows] = useState(undefined);
const [dancingLights, setDancingLights] = useState(undefined);
const [burningHands, setBurningHands] = useState(undefined);

const apiUrls = ["/equipment/dagger", "/spells/acid-arrow", "/spells/dancing-lights", "/spells/burning-hands", 
                "/equipment/crossbow-heavy", "/equipment/potion-of-healing", "/spells/magic-missile", "/equipment/maul", 
                "/equipment/longsword", "/equipment/mace"];
                //get 0th slot level
const apiFilters = [["name", "desc", {"damage":"damage_type"}, {"damage": "damage_dice"}],
                ["name", "desc", {"damage":"damage_type"}, {"damage":"damage_at_slot_level"}],
                ["name", "desc"], 
                ["name", "desc", {"damage":"damage_type"}, {"damage":"damage_at_slot_level"}],
                ["name", "desc", {"damage":"damage_type"}, {"damage": "damage_dice"}],
                ["name", "desc", ],  //do regex search for how much it heals in desc. 
                ["name", "desc", {"damage":"damage_type"}, {"damage":"damage_at_slot_level"}],
                ["name", {"damage":"damage_type"}, {"damage": "damage_dice"}],
                ["name", {"damage":"damage_type"}, {"damage": "damage_dice"}],
                ["name", {"damage":"damage_type"}, {"damage": "damage_dice"}]];

let globalCache = {};

useEffect( ()=> {
  if(Object.keys(globalCache).length === 0){
    for(let i = 0; i < apiUrls.length; i++){
      console.log("url", apiUrls[i]);
      axios.get("https://www.dnd5eapi.co/api"  + apiUrls[i])
      .then( res => {
          // console.log("res.data", res.data);
          let filteredObj = {};
          for(let j = 0; j < apiFilters[i].length; j++){
            let field = apiFilters[i][j];
            if(typeof field === "object"){
              if(filteredObj["damage"] === undefined){
                filteredObj["damage"] = {};
              }
              switch(field["damage"]){
                case "damage_type":
                  filteredObj["damage"]["damage_type"] = {};
                  filteredObj["damage"]["damage_type"]["name"] = res.data["damage"]["damage_type"]["name"];
                  break;
                case "damage_at_slot_level":
                  filteredObj["damage"]["damage_at_slot_level"] = {};
                  let key0 = Object.keys(res.data["damage"]["damage_at_slot_level"])[0];
                  filteredObj["damage"]["damage_at_slot_level"][key0] = res.data["damage"]["damage_at_slot_level"][key0];
                  break;
                case "damage_dice":
                  filteredObj["damage"]["damage_dice"] = res.data["damage"]["damage_dice"];
                  break;
              }
            }
              filteredObj[field] = res.data[field];
          }
          globalCache[filteredObj.name] = filteredObj;
      });
    }
    console.log("globalCache", globalCache);
  }

  // if(daggers !== undefined){
  //   console.log("daggers", daggers);
  // }
  // if(acidArrows !== undefined){
  //   console.log(acidArrows);
  // }
  // if(dancingLights !== undefined){
  //   console.log(dancingLights);
  // }
  // if(burningHands !== undefined){
  //   console.log(burningHands);
  // }
});

const getDaggers = (e) => {
  e.preventDefault();
  axios.get("http://localhost:8080/Daggers")
  .then( res => {
    setDaggers(res.data);
    console.log(res.data);
  });
}

const getAcidArrows = (e) => {
  e.preventDefault();
  axios.get("http://localhost:8080/AcidArrows")
  .then( res => {
    setAcidArrows(res.data);
    console.log(res.data);
  });
}

const getDancingLights = (e) => {
  e.preventDefault();
  axios.get("http://localhost:8080/DancingLights")
  .then( res => {
    setDancingLights(res.data);
    console.log(res.data);
  });
}

const getBurningHands = (e) => {
  e.preventDefault();
  axios.get("http://localhost:8080/BurningHands")
  .then( res => {
    setBurningHands(res.data);
    console.log(res.data);
  });
}

  return (
    <div className="App">
      <header className="App-header">
        <p>
          <div><button onClick={getDaggers}> Get Daggers</button></div>
          <ol>
            {daggers && daggers.map((dagger) => <li className="listItem"><Dagger dagger={dagger}/></li>)}
          </ol>
          <div><button onClick={getAcidArrows}> Get Acid Arrows</button></div>
          <ol>
            {acidArrows && acidArrows.map((acidArrow) => <li className="listItem"><AcidArrow acidArrow={acidArrow}/></li>)}
          </ol>
          <div><button onClick={getDancingLights}> Get Dancing Lights</button></div>
          <ol>
            {dancingLights && dancingLights.map((dancingLight) => <li className="listItem"><DancingLights dancingLights={dancingLight}/></li>)}
          </ol>
          <div><button onClick={getBurningHands}> Get Burning Hands</button></div>
          <ol>
            {burningHands && burningHands.map((burningHand) => <li className="listItem"><BurningHands burningHand={burningHand}/></li>)}
          </ol>
        </p>
      </header>
    </div>
  );
}