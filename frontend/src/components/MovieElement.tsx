import {MovieType} from "../module/MovieType";

type MovieElementProps = {
    movie: MovieType;
}
export default function MovieElement(props: MovieElementProps) {

    return (
    <div>
        <h3>{props.movie.name}</h3>
        <p>{props.movie.year}</p>
        <img src={props.movie.image} alt={"Poster of " + props.movie.name + "movie"}/>
    </div>
    )
}