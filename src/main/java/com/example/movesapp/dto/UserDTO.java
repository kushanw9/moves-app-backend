package com.example.movesapp.dto;

import com.example.movesapp.entity.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String username;
    private String password;
    private Role role;
    private Set<MovieDTO> paidMovies;

    public UserDTO(String username, String password, Role role, Set<MovieDTO> paidMovies) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.paidMovies = paidMovies;
    }
    public UserDTO(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
