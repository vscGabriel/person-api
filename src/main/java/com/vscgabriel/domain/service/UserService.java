package com.vscgabriel.domain.service;

import com.vscgabriel.domain.models.User;

public interface UserService {
    User findById(Long id);
    User findByEmail(String email);
    User findByCpf(String cpf);
    void createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
