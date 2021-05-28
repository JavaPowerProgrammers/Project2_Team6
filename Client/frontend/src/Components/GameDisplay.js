import {React, useState, useEffect} from 'react';
import axios from 'axios';
import '../App.css';
import SubDisplay from "./SubDisplay"
import StatsDisplay from "./StatsDisplay"
import MiniDisplay from "./MiniDisplay"
import TextDisplay from "./TextDisplay"
import GameLogic from "./GameLogic"
import Inventory from "./Inventory"
import GameDisplayContent from "./GameDisplayContent"
import { useDispatch, useSelector } from "react-redux"
import { changeText, changeSubState , changeLogic, setTest} from "../redux/mainReducerState"

export default function GameDisplay(){
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  const [dndApiData, setDndApiData] = useState(undefined);
  const [torch, setTorch] = useState(undefined);
  const [key, setKey] = useState(undefined);
  const [rope, setRope] = useState(undefined);
  const [room, setRoom] = useState(undefined);
  const [creatures, setCreatures] = useState(undefined);
  const [thirdPartyApiData, setThirdPartyApiData] = useState(undefined);
  const [processed, setProcessed] = useState(false);

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
    if(room === undefined){
      axios.get('http://localhost:8080/Entrance')
      .then( res => {
          setRoom(res.data);
      });
    }

    if(dndApiData === undefined){
      axios.get('http://localhost:8080/dndApiData')
      .then( res => {
          setDndApiData(res.data);
      });
    }

    if(creatures === undefined){
      axios.get('http://localhost:8080/Creatures')
      .then( res => {
          setCreatures(res.data);
      });
    }

    if(torch === undefined){
      axios.get('http://localhost:8080/Torches')
      .then( res => {
          setTorch(res.data);
      });
    }

    if(rope === undefined){
      axios.get('http://localhost:8080/Ropes')
      .then( res => {
          setRope(res.data);
      });
    }

    if(key === undefined){
      axios.get('http://localhost:8080/Keys')
      .then( res => {
          setKey(res.data);
      });
    }

    if(thirdPartyApiData === undefined){
      let allfilteredObjects = {};
        for(let i = 0; i < apiUrls.length; i++){
          // console.log("url", apiUrls[i]);
          axios.get("https://www.dnd5eapi.co/api"  + apiUrls[i])
          .then( res => {
              // console.log("res.data", res.data);
              // setThirdPartyApiData(res.data);
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
              console.log(filteredObj.name, filteredObj);
              allfilteredObjects[filteredObj.name] = filteredObj;
          });
        }
        setThirdPartyApiData(allfilteredObjects);
      }
      // console.log("thirdParty", thirdPartyApiData);
      // console.log(Object.keys(thirdPartyApiData).length);
      if(room && dndApiData && creatures && torch && rope && key && (Object.keys(thirdPartyApiData).length == 10)){
        getGlobalCache();
      }
  });

  const getEntranceRoom = () => {

        // let entranceRoom = {};

        globalCache.roomNext = room.nextRoom;
        
        globalCache.roomActionsLogic = {};
        globalCache.roomActionsDesc = [];
        globalCache.roomActionsImgs = [];
        globalCache.roomActionsChosen = {};
        for(let action of room.actions){
          globalCache.roomActionsLogic[action.desc] = action.actionFragments;
          globalCache.roomActionsDesc.push(action.desc);
          globalCache.roomActionsImgs.push(action.image);
          globalCache.roomActionsChosen[action.desc] = false;
        }

        globalCache.currentMiniDisplay = room.currentMiniDisplay;
        globalCache.roomDesc = room.desc;
        globalCache.roomBGImage = room.roomBGImage;
        console.log("globalCache added entrance room", globalCache);
  };

      //Global Cached Items
      // items:{
      //   torch:{name:"Torch", description:"A very bright torch, wrapped in dusty cloth. Seems to be freshly lit...", img:"res/gifs/items/torch.gif", tag:"other"},
      //   acid_arrow:{name:"Acid-Arrow", description:"A powerful spell", img:"res/imgs/spells/acidarrow.png",tag:"spell", statBuff:"Intelligence", dmg:"4d4"},
      //   dagger:{name:"Dagger", description:"A dagger", img:"res/imgs/weapons/dagger.png",tag:"weapon", statBuff:"Dexterity", dmg:"1d4"}
  
  
      // },
      // //Global Cached Creatures
      // creatures:{
      //   spider:{name:"Mother Spider",atk:5, health:15 ,img:"res/gifs/creatures/spider.gif", dmg:"1d6"}
  
      // },
  const getCachedItems = () => { 
    let cachedItems = {};
    cachedItems.torch = torch;
    cachedItems.rope = rope;
    cachedItems.key = key;

    for(let i = 0; i < dndApiData.length; i++){
      let apiItem = dndApiData[i][0];
      // console.log("apiItem", apiItem);
      // console.log("globalCache.apiItem", globalCache.apiItem);
      // console.log("rjjvna;dfbn", Object.keys(globalCache));
      // globalCache.apiItem = {};
      cachedItems[apiItem] = globalCache[apiItem];
      delete globalCache[apiItem];
      cachedItems[apiItem].img = dndApiData[i][1];
      cachedItems[apiItem].tag = dndApiData[i][2];
      cachedItems[apiItem].statBuff = dndApiData[i][3];
      if ('desc' in cachedItems[apiItem]){
        console.log(cachedItems[apiItem]);
        cachedItems[apiItem].description = cachedItems[apiItem].desc;
        delete cachedItems[apiItem].desc;
      }else{
        cachedItems[apiItem].description = null;
      }
      
      if(cachedItems[apiItem].tag === "spell"){
        if(cachedItems[apiItem].name === "Potion of healing" ||
        cachedItems[apiItem].name === "Dancing Lights"){
          cachedItems[apiItem].dmg = "???"; // needs a swtich statement
        }else{
          // console.log("adfbbwrgbaef", cachedItems[apiItem]);
          // let theKey = Object.keys(cachedItems[apiItem].damage.damage_at_slot_level)[0]
          // console.log("theKey", theKey);
          if("1" in cachedItems[apiItem].damage.damage_at_slot_level){
            cachedItems[apiItem].dmg = cachedItems[apiItem].damage.damage_at_slot_level["1"];
          }else{
            cachedItems[apiItem].dmg = cachedItems[apiItem].damage.damage_at_slot_level["2"];
          }
        }
      }
      if(cachedItems[apiItem].tag === "weapon"){
        cachedItems[apiItem].dmg = cachedItems[apiItem].damage.damage_dice;
      }
      delete cachedItems[apiItem].damage;
    }
    console.log("cachedItems", cachedItems);
    globalCache["items"] = cachedItems;
    console.log("globalCache added items", globalCache);
  };

  const getCachedCreatures = () => {
    let cachedCreatures = {};
    for(let creature of creatures){
      cachedCreatures[creature.name] = creature;
    }
    console.log("cachedCreatures", cachedCreatures);
   
   globalCache.creatures = cachedCreatures;
   console.log("globalCache added creatures", globalCache);
  };

  const getThirdPartyApiData = () => {
    for(let key of Object.keys(thirdPartyApiData)){
      console.log("thirdpartyitem", key);
      globalCache[key] = thirdPartyApiData[key];
    }
    console.log("thirdpartyapidata global cache", globalCache);
  }

  const getGlobalCache = () => {
    if(!processed){
      getThirdPartyApiData();
      getEntranceRoom();
      getCachedCreatures();
      getCachedItems();
      console.log("final global cache", globalCache);
      setProcessed(true);
      // console.log(store);
      // Object.assign(store, globalCache);
      // dispatch(setTest(globalCache));
    }
  }

  //Sub-Display is toggled and conditionally rendered below.
  return(

  <div>
    {/* {cachedItems && <GetCachedItems/>}
    {cachedCreatures && <GetCachedCreatures/>} */}
    {/* {room && <GetEntranceRoom/>} */}
    {/* <button onClick={handleClick}>Get Global Cache</button> */}
    {store.inventoryMenu==true&& <Inventory/>}
    {store.logicSwitch==true&& <GameLogic/>}
    {store.subState==true&& <SubDisplay message= {store.subExitMessage} option={store.subOption} content={store.subContent}/>}
    <StatsDisplay/>
    <MiniDisplay imgName={store.currentMiniDisplay}/>
    <GameDisplayContent roomDesc={store.roomDesc} roomActionsDesc={store.roomActionsDesc} roomActionsImgs={store.roomActionsImgs}/>
  </div>
  )

}
