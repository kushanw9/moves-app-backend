package com.example.movesapp.entity;

import com.example.movesapp.entity.util.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`user`")

public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Role role;

    // user should have a movie list
    @ManyToMany
    @JoinTable(name = "user_movie",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> paidMovies;
}
