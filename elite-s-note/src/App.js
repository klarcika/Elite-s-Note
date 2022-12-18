import React from 'react';
//import logo from './logo.svg';
import './App.css';
import Routing from './components/routing/Routing';
import { BrowserRouter } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routing />
      </BrowserRouter>
    </div>
  );
}

export default App;