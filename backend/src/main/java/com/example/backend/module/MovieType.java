package com.example.backend.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieType {
    String id;
    String name;
    int year;
    String image;
}
