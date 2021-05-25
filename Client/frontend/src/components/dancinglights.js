import axios from 'axios';
import {React, useState, useEffect} from 'react'
import '../App.css';

export const DancingLights = (props) => {
    const [data, setData] = useState(undefined);

    useEffect( () => {
        if(data === undefined){
            axios.get("https://www.dnd5eapi.co/api"  + props.dancingLights.url)
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
      {data && <div>url: {data.url}</div>}
    </div>);
  };