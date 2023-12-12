package com.example.movesapp;

import com.example.movesapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestMoviesRepository extends JpaRepository<Movie,String> {
}
