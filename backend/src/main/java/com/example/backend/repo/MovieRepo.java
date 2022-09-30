package com.example.backend.repo;

import com.example.backend.module.MovieType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class MovieRepo {

    private UUID key;
    private Map<UUID,MovieType> movieMap;

    public MovieRepo(List<MovieType> movieList) {

        Map<UUID,MovieType> temp = new HashMap<>();
        for (MovieType movie : movieList){
            this.key = movie.getId();
            temp.put(movie.getId(),movie);
        }
        this.movieMap = temp;
    }


    public List<MovieType> getAllMovies(){
        return List.copyOf(movieMap.values());
    }

//    private Map<String,MovieType> addMovies() {
//        Map<String,MovieType> temp = new HashMap<>();
//        temp.put("0", new MovieType(UUID.randomUUID(),"Forrest Gump",1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105"));
//        temp.put("1",new MovieType(UUID.randomUUID(),"New Kids Turbo",2010, "https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531"));
//        return temp;
//    }

    public MovieType addNewMovie(MovieType postedMovieWithId) {
        UUID temp = postedMovieWithId.getId();
        movieMap.put(postedMovieWithId.getId(),postedMovieWithId);
        return movieMap.get(temp);
    }

    public MovieType deleteMovie(UUID key) {
        return movieMap.remove(key);
    }
}
