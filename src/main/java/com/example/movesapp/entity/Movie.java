package com.example.movesapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Blob;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "movie")
@ToString(exclude = "paidUsers")
public class Movie {
    @Id
    private String id;
    private String title;
    private String category;
    private byte[] image;
    private String description;
    @ManyToMany(mappedBy = "paidMovies")
    private Set<User> paidUsers;
}
