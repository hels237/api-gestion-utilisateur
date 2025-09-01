package com.k48.gestion_utilisateur.service;

import com.k48.gestion_utilisateur.dto.UserRequestDTO;
import com.k48.gestion_utilisateur.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO request);
    UserResponseDTO updateUser(Long id, UserRequestDTO request);
    void deleteUser(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
}