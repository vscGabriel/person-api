package com.vscgabriel.domain.repository;

import com.vscgabriel.domain.models.User;

public interface UserRepository {

    User findById(Long id);
    User findByEmail(String email);
    void save(User user);
    User update(User user);
    void delete(Long id);
}
