import axios from 'axios';
import {React, useState, useEffect} from 'react'
import '../App.css';

export const BurningHands = (props) => {
  const [data, setData] = useState(undefined);

  useEffect( () => {
      if(data === undefined){
          axios.get("https://www.dnd5eapi.co/api"  + props.burningHand.url)
          .then( res => {
              setData(res.data);
              console.log(res.data);
          });
      }

  }, [data]);
    return (
    <div>
      {data && <div>name: {data.name}</div>}
      {data && <div>description: {data.desc ? data.desc : "N/A"}</div>}
      <div> damage ->
        {data && <div>damage_type: {data.damage.damage_type.name}</div>}
        <div> damage_at_slot_level ->
          {data && <div>1: {data.damage.damage_at_slot_level["1"]}</div>}
          {data && <div>2: {data.damage.damage_at_slot_level["2"]}</div>}
          {data && <div>3: {data.damage.damage_at_slot_level["3"]}</div>}
          {data && <div>4: {data.damage.damage_at_slot_level["4"]}</div>}
          {data && <div>5: {data.damage.damage_at_slot_level["5"]}</div>}
          {data && <div>6: {data.damage.damage_at_slot_level["6"]}</div>}
          {data && <div>7: {data.damage.damage_at_slot_level["7"]}</div>}
          {data && <div>8: {data.damage.damage_at_slot_level["8"]}</div>}
          {data && <div>9: {data.damage.damage_at_slot_level["9"]}</div>}
        </div>
      </div>
      {data && <div>url: {data.url}</div>}
    </div>);
  };