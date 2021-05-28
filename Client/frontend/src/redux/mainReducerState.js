import { createSlice } from "@reduxjs/toolkit";

export const mainSlice = createSlice({
  name: "mainR",
  initialState: {
    //Prelims

    //Room Display Data
    currentMiniDisplay:null,
    roomBGImage:"/res/imgs/backgrounds/spidernest.jpg",
    roomDesc:"You've Come Across A Mysterious Dark Room Filled With Cobb-Webs And See A Giant Mother Spider On The Wall... What Do You Do? ",
    roomActionsDesc:["Attack Spider.","Examine Dead Body In The Corner.","Open Chest.","Pick Up Torch From Ground.", "Go Into Goblin Room."],
    roomActionsImgs:["res/gifs/creatures/spider.gif","res/imgs/other/bonepile.png","res/gifs/other/chest.gif","res/gifs/items/torch.gif","res/imgs/other/door.png"],
    roomActionsChosen:{
      "Attack Spider.":false,
      "Examine Dead Body In The Corner.":false,
      "Open Chest.":false,
      "Pick Up Torch From Ground.":false,
      "Go Into Goblin Room.":false
    },
    roomActionsLogic:{
      "Attack Spider." : [[1,"Youre entering the battle with the Spider! Be prepared!!!"],[4,"spider"]],
      "Examine Dead Body In The Corner." : [ [1," Lying tussled on the stone floor is the corpse of a humanoid creature of some kind. As you search around" +
      "you realize that it is too tightly wrapped to pull away any of the silk. However, next to the cadaver a scroll" +
      " is just lying there, seeming to beckon you and use it."]],
      "Open Chest." : [[1,"Noticing and avoiding the trap, you are able to open the chest carefully enough to not " +
      "trigger the fireball. Looking inside your see a few desirable items, your first loot of the day."],[2,["torch","dagger","dagger"]]],
      "Pick Up Torch From Ground.":[[1,"You found a torch on the ground!"],[2,["torch"]]],
      "Go Into Goblin Room.":[[1, "You are entering the cave room.  Be Prepared..."]]
    },
    roomNext: "foyar",
    /*"roomNext": "Foyar",
  "roomActionsLogic": {
    "Examine Statue": [
      [
        "1",
        "In front of you stands a marble statue of what appears to be an elven woman wearing robes. It is hardto determine who it depicts as it is heavily damaged. You see claw marks ravaging the lower parts and acid bubbles on the upper torso. Her left arm seems to have been broken off and lies on the ground next to her. "
      ]
    ],
    "Examine Tracks": [
      [
        "1",
        " Beneath your feet you see a few trails of footprint. They are smaller than your and apear to be of goblin origin. They lead both in and out of the curtain of ivy blocking vision into the dungeon, with more tracks leading into, than out of. One hopes you are prepared for the invasion of a goblin home. "
      ]
    ],
    "Enter Foyar Room": [
      [
        "1",
        " You enter what appears to be a normal cave. You see on the other end, what could generouslybe called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway"
      ]
    ]
  },
  "roomActionsDesc": [
    "Examine Statue",
    "Examine Tracks",
    "Enter Foyar Room"
  ],
  "roomActionsImgs": [
    null,
    null,
    null
  ],
  "roomActionsChosen": {
    "Examine Statue": false,
    "Examine Tracks": false,
    "Enter Foyar Room": false
  },
  "currentMiniDisplay": "",
  "roomDesc": "Before you lies the adventurous dungeon you have chosen. To your left there is a statue that is practically unrecognizable. You see tracks in the mud leading into the ivy covered entryway of the dungeon. It is a beautiful day outside, but your purpose and dreams of fortune and fame, lie within",
  "roomBGImage": "",*/

    //Sub-Room Display Data
    subState:false,
    subOption:1, //initial value of 1
    subContent:null,
    subExitMessage:"OK",

    //Main Logic
    logicSwitch:false,
    logicValue:null,

    //Inventory
    inventoryMenu:false,
    inventory:["acid_arrow","dagger"],
    inventoryMessage:"",

    //Character Data
    stats:{
      Race:"Elf",
      Class:"Wizard",
      maxHealth:20,
      Health:20,
      Dexterity:10,
      Strength:5,
      Constitution:11,
      Intelligence:20,
      Wisdom: 15,
      Charisma: 20,
    },

    //Global Cached Items
    items:{
      torch:{name:"Torch", description:"A very bright torch, wrapped in dusty cloth. Seems to be freshly lit...", img:"res/gifs/items/torch.gif", tag:"other"},
      acid_arrow:{name:"Acid-Arrow", description:"A powerful spell", img:"res/imgs/spells/acidarrow.png",tag:"spell", statBuff:"Intelligence", dmg:"4d4"},
      dagger:{name:"Dagger", description:"A dagger", img:"res/imgs/weapons/dagger.png",tag:"weapon", statBuff:"Dexterity", dmg:"1d4"}


    },
    //Global Cached Creatures
    creatures:{
      spider:{name:"Mother Spider", health:50 ,img:"res/gifs/creatures/spider.gif", dmg:"1d6"}

    },

    //Combat Data
    combatMessage:"Choose Your Weapon:",//Updates combat action alerts, initial state is always "Choose Your Weapon"
    combatMessageCreature:"", //Initial state is always empty
    totalCombatDamage:0, //initial state always starts at 0

    navigationTag:1

  },


  reducers: {
    changeText: (state,action) =>{state.title=action.payload;},
    changeMiniDisplay: (state,action) =>{state.currentMiniDisplay=action.payload;},
    changeActionChoice: (state,action) =>{state.roomActionsChosen.[action.payload]=true;},
    changeSubState: (state,action) =>{state.subState=action.payload;},
    changeSubOption: (state,action) =>{state.subOption=action.payload;},
    changeSubContent: (state,action) =>{state.subContent=action.payload;},
    changeSubExitMessage: (state,action) =>{state.subExitMessage=action.payload;},
    changeLogic: (state,action) =>{state.logicSwitch=action.payload;},
    changeLogicValue: (state,action) =>{state.logicValue=action.payload;},

    changeHealth: (state,action) =>{state.stats.Health=action.payload;},
    changeVisbility: (state,action) =>{state.stats.visibility=action.payload;},

    updateInventory: (state,action) =>{state.inventory=action.payload;},
    accessInventory: (state,action) =>{state.inventoryMenu=action.payload;},
    changeInventoryMessage: (state,action) =>{state.inventoryMessage=action.payload;},

    changeCombatMessage: (state,action) =>{state.combatMessage=action.payload;},
    changeCombatMessageCreature: (state,action) =>{state.combatMessageCreature=action.payload;},
    changeTotalCombat: (state,action) =>{state.totalCombatDamage=action.payload;},

    setNavigation: (state,action) =>{state.navigationTag=action.payload;},
    setTest:(state,action) =>{

      //state.navigationTag=action.payload;
      // alert("hit");
      for(let key in action.payload){
        // console.log("key", key);
        // alert(action.payload[key]);
        state[key]=action.payload[key]
      }

    }
    
  }
}
);
export const {setNavigation,changeCombatMessageCreature, changeTotalCombat, changeCombatMessage,changeInventoryMessage, accessInventory, updateInventory, changeText, changeMiniDisplay, changeActionChoice, changeSubState, changeLogic, changeLogicValue, changeSubOption,changeSubContent,changeSubExitMessage,changeHealth,changeVisbility, setTest} = mainSlice.actions;

export default mainSlice.reducer;
