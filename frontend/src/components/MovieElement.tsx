import {MovieType} from "../module/MovieType";

type MovieElementProps = {
    movie: MovieType;
}
export default function MovieElement(props: MovieElementProps) {

    const displayYear = () => {
        const year = props.movie.year;
        return (year < 1800 && year > new Date().getFullYear())?year:"-"
    }

    return (
    <div>
        <h3>{props.movie.name}</h3>
        <p>{displayYear()}</p>
        <img src={props.movie.image} alt={"Poster of " + props.movie.name + "movie"}/>
    </div>
    )
}