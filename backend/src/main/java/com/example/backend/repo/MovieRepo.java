package com.example.backend.repo;

import com.example.backend.module.MovieType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class MovieRepo {

    private String key;
    private final Map<String,MovieType> movieMap;

    public MovieRepo(List<MovieType> movieList) {

        Map<String,MovieType> temp = new HashMap<>();
        for (MovieType movie : movieList){
            this.key = movie.getId();
            temp.put(movie.getId(),movie);
        }
        this.movieMap = temp;
    }


    public List<MovieType> getAllMovies(){
        return List.copyOf(movieMap.values());
    }



    public MovieType addNewMovie(MovieType postedMovieWithId) {
        String temp = postedMovieWithId.getId();
        movieMap.put(postedMovieWithId.getId(),postedMovieWithId);
        return movieMap.get(temp);
    }

    public MovieType deleteMovie(String key) {
        MovieType temp = movieMap.remove(key);
        return temp;
    }
}
