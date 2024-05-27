package com.vscgabriel.domain.service;

import com.vscgabriel.domain.models.User;

public interface UserService {
    User findById(Long id);
    void createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
