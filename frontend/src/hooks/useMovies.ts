import {useEffect, useState} from "react";
import axios from "axios";

export default function useMovies() {

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios.get("api/movies")
            .then((answer) => answer.data)
            .then((data) => setMovies(data))
            .catch(() => console.error())
    }, [])



    return {movies};
}