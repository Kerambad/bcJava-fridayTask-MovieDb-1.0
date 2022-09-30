import {MovieType} from "../module/MovieType";
import MovieElement from "./MovieElement";
import {useState} from "react";

type MovieGalleryProps = {
    movies: MovieType[]
}
export default function MovieGallery(props: MovieGalleryProps) {


    const outputMovies = (props.movies.map((movie) => {
        return <MovieElement movie={movie}/>
    }))

    return (
    <>
        {outputMovies}
    </>
    )
}