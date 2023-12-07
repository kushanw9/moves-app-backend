package com.example.movesapp.service.impl;

import com.example.movesapp.dto.UserDTO;
import com.example.movesapp.entity.User;
import com.example.movesapp.entity.util.Role;
import com.example.movesapp.repository.UserRepository;
import com.example.movesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public UserDTO findUserByUserId(String userId) {
        return mapper.map(userRepository.findById(userId), UserDTO.class);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return mapper.map(userRepository.save(mapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if (!userRepository.existsById(userDTO.getId())) {
            // throw an exception
        }
        return mapper.map(userRepository.save(mapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public void deleteUserById(String userId) {
        if (!userRepository.existsById(userId)) {
            // throw an exception
        }
        userRepository.deleteById(userId);

    }

    @Override
    public boolean isUserAnAdminById(String userId) {
        return findUserByUserId(userId).getRole().equals(Role.ADMIN);
    }
}
