import React from 'react';
import './App.css';
import {HashRouter, Route, Routes} from "react-router-dom";
import MainPage from "./pages/MainPage";
import useMovies from "./hooks/useMovies";


function App() {

    const {movies, postNewMovie, deleteMovie} = useMovies();

    return (
        <div className="App">
            <HashRouter>
                <Routes>
                    <Route path={"/"} element={<MainPage movies={movies} addMovies={postNewMovie} delete={deleteMovie}/>}/>
                </Routes>
            </HashRouter>
        </div>
    );
}

export default App;
