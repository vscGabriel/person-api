package com.vscgabriel.infrastructure.repository;

import com.vscgabriel.domain.models.User;
import com.vscgabriel.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
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

    @Override
    @Transactional
    public User findByCpf(String cpf) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.cpf = :cpf", User.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
}
