package com.example.backend.controller;

import com.example.backend.module.MovieType;
import com.example.backend.repo.MovieRepo;
import com.example.backend.service.IdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MovieRepo repo;

    @MockBean
    private IdService fakeId;

    @Test
    void getAllMovies() throws Exception {
        //GIVEN
        repo.save(new MovieType("1", "Forrest Gump", 1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105"));
        repo.save(new MovieType("2", "New Kids Turbo", 2010, "https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531"));

        String expectedJSON = """
                [
                    {
                        "id": "1",
                        "name": "Forrest Gump",
                        "year": 1994,
                        "image": "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105"
                    },
                    {
                        "id": "2",
                        "name": "New Kids Turbo",
                        "year": 2010,
                        "image": "https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531"
                    }
                ]
                """;
        //WHEN & THEN
        mvc.perform(get("/api/movies/"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void addNewMovie() throws Exception {
        //GIVEN
        String postJSON = """
                    {
                    "name":"New Kids Turbo",
                    "year":2010,
                    "image":"https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531"
                }
                """;
        String expectedJSON = """
                {
                    "id": "1",
                    "name":"New Kids Turbo",
                    "year":2010,
                    "image":"https://upload.wikimedia.org/wikipedia/en/8/85/New_Kids_Turbo_poster.jpg?20200612000531"
                }
                """;
        when(fakeId.getRandomId()).thenReturn("1");
        //WHEN
        mvc.perform(
                        post("/api/movies")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content(postJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));

        //THEN

    }

    @Test
    void deleteMovie() throws Exception {
        //GIVEN
        repo.save(new MovieType("1", "Forrest Gump", 1994, "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg?20180102220105"));
        //WHEN
        mvc.perform(delete("/api/movies/1"))
                .andExpect(status().isOk());
        //THEN
        assertFalse("[]", repo.findById("1").isPresent());
    }

}