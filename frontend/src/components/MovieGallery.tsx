import {MovieType} from "../module/MovieType";
import MovieElement from "./MovieElement";
import "./MovieGallery.css"

type MovieGalleryProps = {
    movies: MovieType[]
    delete: (deleteFunction:string) => void
}
export default function MovieGallery(props: MovieGalleryProps) {


    const outputMovies = (props.movies.map((movie) => {
        return <MovieElement movie={movie} delete={props.delete} key={movie.id}/>
    }))

    return (
    <div className={"gallery"}>
        {outputMovies || <p>No element</p>}
    </div>
    )
}