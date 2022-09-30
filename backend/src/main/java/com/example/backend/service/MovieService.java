package com.example.backend.service;

import com.example.backend.module.MovieType;
import com.example.backend.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final MovieRepo repo;

    @Autowired
    public MovieService(MovieRepo repo) {
        this.repo = repo;
    }

    public List<MovieType> getAllMovies() {
        return repo.getAllMovies();
    }


}
