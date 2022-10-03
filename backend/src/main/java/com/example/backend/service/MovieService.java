package com.example.backend.service;

import com.example.backend.module.MovieDtoType;
import com.example.backend.module.MovieType;
import com.example.backend.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepo repo;
    private final IdService idService;

    @Autowired
    public MovieService(MovieRepo repo, IdService idService) {
        this.repo = repo;
        this.idService = idService;
    }



    public List<MovieType> getAllMovies() {
        return repo.getAllMovies();
    }


    public MovieType addNewMovie(MovieDtoType postedMovie) {
        return repo.addNewMovie(new MovieType(
                idService.getRandomId(),
                postedMovie.getName(),
                postedMovie.getYear(),
                postedMovie.getImage()));
    }

    public MovieType deleteMovie(String key) {
        return repo.deleteMovie(key);
    }
}
