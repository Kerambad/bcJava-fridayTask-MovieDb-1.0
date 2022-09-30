import {useState} from "react";
import {MovieDtotype} from "../module/MovieDtotype";
import "./AddNewMovieForm.css"

type AddNewMovieFormProps = {
    newMovie: (toAdd:MovieDtotype) => void
}

export default function AddNewMovieForm(props: AddNewMovieFormProps) {

    const emptyMoviePlaceholder: MovieDtotype = {
        name: "",
        year: 0,
        image: ""
    }

    const [movie, setMovie] = useState(emptyMoviePlaceholder);


    return (
    <>

        <hr/>
        <form className={"addMovieForm"} onSubmit={(action) => {
            action.preventDefault()
            props.newMovie(movie)
            setMovie(emptyMoviePlaceholder)
        }}>
            <input
                type={"text"}
                className={""}
                name={"name"}
                value={movie.name}
                placeholder={"Name"}
                onChange={(action) => setMovie((old) => ({...old, [action.target.name]:action.target.value}))}
                required={true}
            />
            <input
                type={"text"}
                className={""}
                name={"year"}
                value={movie.year}
                onChange={(action) => setMovie((old) => ({...old, [action.target.name]:action.target.value}))}
                required={true}
            />
            <input
                type={"text"}
                className={""}
                name={"image"}
                value={movie.image}
                placeholder={"Image Url"}
                onChange={(action) => setMovie((old) => ({...old, [action.target.name]:action.target.value}))}
                required={false}
            />
            <input
                type={"submit"}
            />
        </form>
    </>
    )
}