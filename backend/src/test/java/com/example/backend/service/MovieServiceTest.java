package com.example.backend.service;

import com.example.backend.module.MovieDtoType;
import com.example.backend.module.MovieType;
import com.example.backend.repo.MovieRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    MovieRepo repo = mock(MovieRepo.class);
    IdService fakeId = mock(IdService.class);
    MovieService service = new MovieService(repo, fakeId);


    @Test
    void getAllMoviesShouldReturnAllMovies() {
        //GIVEN
        when(repo.findAll()).thenReturn(List.of(
                testMovie(),
                new MovieType("2", "New Kids Turbo", 2010, "https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531")
        ));
        //WHEN
        List<MovieType> actual = service.getAllMovies();
        //THEN
        List<MovieType> expected = List.of(
                testMovie(),
                new MovieType("2", "New Kids Turbo", 2010, "https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531")
        );
        assertEquals(expected, actual);

    }

    @Test
    void addNewMovieShouldReturnAddedMovieWithId() {
        //GIVEN
        MovieDtoType testDtoObject = new MovieDtoType("Forrest Gump", 1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105");
        when(fakeId.getRandomId()).thenReturn("1");
        when(repo.save(testMovie()))
                .thenReturn(testMovie());
        //WHEN
        MovieType actual = service.addNewMovie(testDtoObject);
        //THEN
        MovieType expected = new MovieType("1", "Forrest Gump", 1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105");
        assertEquals(expected, actual);
    }

    @Test
    void deleteMovie() {
        //GIVEN
        when(repo.findById("1")).thenReturn(Optional.empty());
        //WHEN
        Optional<MovieType> actual = service.deleteMovie("1");
        //THEN
        assertFalse(actual.isPresent());
    }

    private MovieType testMovie() {
        return new MovieType("1", "Forrest Gump", 1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105");

    }

}