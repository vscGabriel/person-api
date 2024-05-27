package com.vscgabriel.infrastructure.repository;

import com.vscgabriel.domain.models.User;
import com.vscgabriel.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User findByEmail(String email) {
        return entityManager.find(User.class,email);
    }

    @Override
    public void save(User user) {
       entityManager.persist(user);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,id);
        if(user != null) {
            entityManager.remove(user);
        }
    }
}
