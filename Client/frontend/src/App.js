import logo from './logo.svg';
import './App.css';
import GameDisplay from "./Components/GameDisplay"
import NavBar from "./Components/NavBar"
import Home from "./Components/Home"
import About from "./Components/About"
import Rules from "./Components/Rules"
import NavigationController from "./Components/NavigationController"
import { useDispatch, useSelector } from "react-redux"


function App() {
  const store= useSelector((state) => state.main);
  const dispatch = useDispatch();
  return (
     <div className="App">
     <NavBar/>
     <NavigationController/>
     </div>

  );
}

export default App;
