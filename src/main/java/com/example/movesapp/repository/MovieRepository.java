package com.example.movesapp.repository;

import com.example.movesapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {
    List<Movie> findMovieByIdLikeOrTitleIgnoreCaseOrCategoryLike(String id, String title, String category);
}
