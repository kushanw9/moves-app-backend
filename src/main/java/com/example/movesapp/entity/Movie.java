package com.example.movesapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "movie")
@ToString(exclude = "paidUsers")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String title;
    private String category;
    private byte[] image;
    private String description;
    @ManyToMany(mappedBy = "paidMovies")
    @JsonBackReference
    private Set<User> paidUsers;
}
