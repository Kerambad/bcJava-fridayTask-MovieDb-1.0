import MovieGallery from "../components/MovieGallery";
import {MovieType} from "../module/MovieType";

type mainPageProps = {
    movies: MovieType[]
}
export default function MainPage(props: mainPageProps) {

    return (
    <>
        <MovieGallery movies={props.movies}/>
    </>
    )
}