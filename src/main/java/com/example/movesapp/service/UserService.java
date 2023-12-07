package com.example.movesapp.service;

import com.example.movesapp.dto.UserDTO;
import com.example.movesapp.entity.User;

public interface UserService {

    UserDTO findUserByUserId(String userId);
    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUserById(String userId);
    boolean isUserAnAdminById(String userId);

}
