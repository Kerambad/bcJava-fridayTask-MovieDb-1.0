import React from 'react';
import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import MainPage from "./pages/MainPage";



function App() {
    return (
        <div className="App">
            <HashRouter>
                <Routes>
                    <Route path={"/books/api"} element={<MainPage/>}/>
                </Routes>
            </HashRouter>
        </div>
    );
}

export default App;
