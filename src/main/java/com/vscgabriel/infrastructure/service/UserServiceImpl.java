package com.vscgabriel.infrastructure.service;

import com.vscgabriel.domain.models.User;
import com.vscgabriel.domain.repository.UserRepository;
import com.vscgabriel.domain.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User existUser = userRepository.findById(user.getId());
        if(existUser != null) {
            existUser.setName(user.getName());
            existUser.setPassword(user.getPassword());
            existUser.setCpf(user.getCpf());
            existUser.setEmail(user.getEmail());

           return userRepository.update(existUser);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
