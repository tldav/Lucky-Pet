import React from "react";
import { BrowserRouter } from "react-router-dom";
import Router from "./Router";
import NavBar from "../regions/NavBar";

function App() {
  return (
    <div className="app">
      <BrowserRouter>
        <NavBar />
        <Router />
      </BrowserRouter>
    </div>
  );
}

export default App;
