import MovieGallery from "../components/MovieGallery";
import {MovieType} from "../module/MovieType";
import {MovieDtotype} from "../module/MovieDtotype";
import AddNewMovieForm from "../components/AddNewMovieForm";

type mainPageProps = {
    movies: MovieType[]
    addMovies: (addMovieFunction: MovieDtotype) => void
}
export default function MainPage(props: mainPageProps) {

    return (
    <>
        <MovieGallery movies={props.movies}/>
        <AddNewMovieForm newMovie={props.addMovies}/>
    </>
    )
}