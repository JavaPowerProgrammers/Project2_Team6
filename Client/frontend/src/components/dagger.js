import axios from 'axios';
import {React, useState, useEffect} from 'react'
import '../App.css';

export const Dagger = (props) => {
    const [data, setData] = useState(undefined);

    useEffect( () => {
        if(data === undefined){
            axios.get("https://www.dnd5eapi.co/api"  + props.dagger.url)
            .then( res => {
                setData(res.data);
                console.log(res.data);
            });
        }
    });

    return (
    <div>
      {data && <div>name: {data.name}</div>}
      {data && <div>description: {data.desc ? data.desc : "N/A"}</div>}
      <div>damage ->
        {data && <div>damage_dice: {data.damage.damage_dice}</div>}
        {data && <div>damage_type: {data.damage.damage_type.name}</div>}
      </div>
      {data && <div>url: {data.url}</div>}
    </div>);
  };