import MovieGallery from "../components/MovieGallery";
import {MovieType} from "../module/MovieType";
import {MovieDtotype} from "../module/MovieDtotype";
import AddNewMovieForm from "../components/AddNewMovieForm";

type mainPageProps = {
    movies: MovieType[]
    addMovies: (addMovieFunction: MovieDtotype) => void
    delete: (deleteFunction: string) => void
}
export default function MainPage(props: mainPageProps) {

    return (
        <>
            <AddNewMovieForm newMovie={props.addMovies}/>
            <MovieGallery movies={props.movies} delete={props.delete}/>
        </>
    )
}