package com.example.backend.controller;

import com.example.backend.module.MovieDtoType;
import com.example.backend.module.MovieType;
import com.example.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MovieController {


    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieType> getAllMovies () {
        return service.getAllMovies();
    }

    @PostMapping
    public MovieType addNewMovie (@RequestBody MovieDtoType postedMovie) {
        return service.addNewMovie(postedMovie);
    }
    @DeleteMapping(path = "{id}")
    public MovieType deleteMovie (@PathVariable UUID id) {
        return service.deleteMovie(id);
    }
}
