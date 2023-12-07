package com.example.movesapp.api;

import com.example.movesapp.dto.MovieDTO;
import com.example.movesapp.service.MovieService;
import com.example.movesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final UserService userService;
    private final MovieService movieService;
    // admin can create a movie
    @PostMapping("/{userId}")
    public MovieDTO createMovie(@PathVariable String userId, @RequestBody MovieDTO movieDTO) {
        if (userService.isUserAnAdminById(userId)) {
            return movieService.saveMovie(movieDTO);
        }
        return null;
    }

    // admin can update a movie
    @PatchMapping("/{userId}")
    public MovieDTO updateMovie(@PathVariable String userId, @RequestBody MovieDTO movieDTO) {
        if (userService.isUserAnAdminById(userId)) {
            return movieService.updateMovie(movieDTO);
        }
        return null;
    }
    // admin can delete a movie
    @DeleteMapping("/{userId}")
    public String deleteMovie(@PathVariable String userId,@RequestParam(value = "q",required = false) String movieId) {
        if (userService.isUserAnAdminById(userId)) {
            if(movieId==null) movieId = "";
            movieService.deleteMovie(movieId);
        }
        return "<h1>Only admin can delete a movie</h1>";
    }

    // get all movies
//    @GetMapping
//    public List<MovieDTO> getAllMovies() {
//        return movieService.getAllMovies();
//    }

    // get movies by name,title or all
    @GetMapping
    public List<MovieDTO> getMovies(@RequestParam(value = "q", required = false) String query) {
        if(query==null) query = "";
        return movieService.findMovie(query);
    }

    // get a movie by id
    @GetMapping("/{movieId}")
    public MovieDTO getAMovie(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }

}
