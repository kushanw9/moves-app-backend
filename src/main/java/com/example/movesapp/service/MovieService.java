package com.example.movesapp.service;

import com.example.movesapp.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(String movieId);

    List<MovieDTO> findMovie(String query);
    MovieDTO saveMovie(MovieDTO movieDTO);

    MovieDTO updateMovie(MovieDTO movieDTO);

    void deleteMovie(String movieId);

}
