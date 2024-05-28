package com.vscgabriel.application.service;

import com.vscgabriel.application.dto.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserAppService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO getPersonById(Long id);
    UserDTO getByCpf(String cpf);
    UserDTO getUserByEmail(String email);
    void deletePerson(Long id);
}
