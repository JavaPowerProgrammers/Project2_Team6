import {React, useState, useEffect} from 'react'
import { Link, useHistory, useLocation} from 'react-router-dom'
import Page from './page'
import './App.css';
import axios from 'axios';
import {AcidArrow} from './components/acidarrow';
import {User} from './components/user'

export default function App() {
const [acidArrow, setAcidArrow] = useState(undefined);
const [user, setUser] = useState(undefined);
const history = useHistory();
// const location = useLocation();


useEffect( ()=> {
  if(acidArrow !== undefined){
    console.log("acidArrow", acidArrow);
  }
  if(user !== undefined){
    console.log("user", user);
  }
}, [acidArrow, history]);

const getAcidArrow = (e) => {
  e.preventDefault();
  axios.get('https://www.dnd5eapi.co/api/spells/acid-arrow/')
  .then( res => {
      setAcidArrow(res.data);
  });
}

const getUser = (e) => {
  e.preventDefault();
  axios.get('http://localhost:8080/hello-world')
  .then( res => {
      setUser(res.data);
      console.log(res.data);
  });
}

  return (
    <div className="App">
      <header className="App-header">
        <p>
          <div><button onClick={getAcidArrow}> Acid Arrow</button></div>
          {acidArrow && <AcidArrow a={acidArrow} />}

          <div><button onClick={getUser}> Get User</button></div>
          {user && <User u={user} />}

        </p>
      </header>
    </div>
  );
}