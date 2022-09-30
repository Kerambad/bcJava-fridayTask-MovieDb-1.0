import {MovieType} from "../module/MovieType";
import MovieElement from "./MovieElement";
import "./MovieGallery.css"

type MovieGalleryProps = {
    movies: MovieType[]
}
export default function MovieGallery(props: MovieGalleryProps) {


    const outputMovies = (props.movies.map((movie) => {
        return <MovieElement movie={movie}/>
    }))

    return (
    <div className={"gallery"}>
        {outputMovies}
    </div>
    )
}