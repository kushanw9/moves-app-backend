package com.example.movesapp.entity;

import com.example.movesapp.entity.util.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`user`")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // user should have a movie list
    @ManyToMany
    @JoinTable(name = "user_movie",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    @JsonManagedReference
    private Set<Movie> paidMovies;
}
