package com.example.backend.service;

import com.example.backend.module.MovieDtoType;
import com.example.backend.module.MovieType;
import com.example.backend.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return repo.findAll();
    }


    public MovieType addNewMovie(MovieDtoType postedMovie) {
        return repo.save(new MovieType(
                idService.getRandomId(),
                postedMovie.getName(),
                postedMovie.getYear(),
                postedMovie.getImage()));
    }

    public Optional<MovieType> deleteMovie(String key) {
        repo.deleteById(key);
        return repo.findById(key);
    }
}
