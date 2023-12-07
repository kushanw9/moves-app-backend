package com.example.movesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MovieDTO {
    private String id;
    private String title;
    private String category;
    private byte[] image;
    private String description;

    public MovieDTO(String title, String category, byte[] image, String description) {
        this.title = title;
        this.category = category;
        this.image = image;
        this.description = description;
    }
}
