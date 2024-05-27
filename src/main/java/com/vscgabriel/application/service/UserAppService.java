package com.vscgabriel.application.service;

import com.vscgabriel.application.dto.UserDTO;

public interface UserAppService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO getPersonById(Long id);
    void deletePerson(Long id);
}
