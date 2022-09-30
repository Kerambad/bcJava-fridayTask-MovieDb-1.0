import {useEffect, useState} from "react";
import axios from "axios";
import { MovieDtotype } from "../module/MovieDtotype";

export default function useMovies() {

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        getAllMovies()
    }, [])

    const getAllMovies = () => {
        axios.get("api/movies")
            .then((answer) => answer.data)
            .then((data) => setMovies(data))
            .catch(() => console.error())
    }
    const postNewMovie = (movieToAdd: MovieDtotype) => {
        axios.post("api/movies", movieToAdd)
            .then(getAllMovies)
            .catch(() => console.error())

    }
    return {movies, postNewMovie};
}