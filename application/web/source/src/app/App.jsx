import React from "react";
import { BrowserRouter } from "react-router-dom";
import Router from "./Router";
import Navbar from "../region/Navbar";
import "./app.css";

function App() {
	return (
		<div className="app">
			<BrowserRouter>
				<Navbar />
				<Router />
			</BrowserRouter>
		</div>
	);
}

export default App;
