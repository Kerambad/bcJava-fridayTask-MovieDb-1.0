import {MovieType} from "../module/MovieType";
import "./MovieElement.css"

type MovieElementProps = {
    movie: MovieType;
    delete: (deleteFunction:string) => void
}
export default function MovieElement(props: MovieElementProps) {

    const displayYear = () => {
        const year = props.movie.year;
        return (year < 1800 && year > new Date().getFullYear())?year:"-"
    }

    return (
    <div className={"movieElement"} >
        <button className={"delete"} onClick={() => props.delete(props.movie.id)}>X</button>
        <h3 className={"title"}>{props.movie.name} ({displayYear()})</h3>
        <img className={"image"} src={props.movie.image} alt={"Poster of " + props.movie.name + "movie"}/>
    </div>
    )
}