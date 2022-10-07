package com.example.backend.repo;

import com.example.backend.module.MovieType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public interface MovieRepo extends MongoRepository<MovieType, String> {

}
