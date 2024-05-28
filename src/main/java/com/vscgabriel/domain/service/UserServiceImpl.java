package com.vscgabriel.domain.service;

import com.vscgabriel.domain.models.User;
import com.vscgabriel.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService{

    @Inject
    UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    @Transactional
    public void createUser(User userReq) {
        User user = new User();
        user.setName(userReq.getName());
        user.setCpf(userReq.getCpf());
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());
        repository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User userReq) {
        User user = repository.findById(userReq.getId());
        if (user != null) {
            user.setName(userReq.getName());
            user.setCpf(userReq.getCpf());
            user.setEmail(userReq.getEmail());
            user.setPassword(userReq.getPassword());
            repository.update(user);
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = repository.findById(id);
        if (user != null) {
            repository.delete(id);
        }
    }
}
