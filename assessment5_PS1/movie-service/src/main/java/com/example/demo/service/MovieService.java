package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;

@Service
public class MovieService {

    private List<Movie> movies = List.of(
            new Movie(1,"Inception","English",250),
            new Movie(2,"RRR","Telugu",220),
            new Movie(3,"Interstellar","English",300)
    );

    public List<Movie> getAllMovies(){
        return movies;
    }

    public Movie getMovieById(int id){
        return movies.stream()
                .filter(m -> m.getId()==id)
                .findFirst()
                .orElseThrow();
    }
}

