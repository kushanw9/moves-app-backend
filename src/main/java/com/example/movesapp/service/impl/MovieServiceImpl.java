package com.example.movesapp.service.impl;

import com.example.movesapp.dto.MovieDTO;
import com.example.movesapp.entity.Movie;
import com.example.movesapp.repository.MovieRepository;
import com.example.movesapp.repository.UserRepository;
import com.example.movesapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(String movieId) {
        return mapper.map(movieRepository.findById(movieId), MovieDTO.class);
    }

    @Override
    public List<MovieDTO> findMovie(String query) {
        return movieRepository.findMovieByIdLikeOrTitleIgnoreCaseOrCategoryLike(query,query,query).stream()
                .map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {

        return mapper.map(movieRepository.save(mapper.map(movieDTO, Movie.class)), MovieDTO.class);
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO) {
        return mapper.map(movieRepository.save(mapper.map(movieDTO, Movie.class)), MovieDTO.class);
    }

    @Override
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }
}
