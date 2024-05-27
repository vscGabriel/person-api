package com.vscgabriel.application.service;

import com.vscgabriel.application.dto.UserDTO;
import com.vscgabriel.domain.models.User;
import com.vscgabriel.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserAppServiceImpl implements UserAppService{

    @Inject
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user =  new User();

        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);

        return convertToDTO(user);
    }

    @Override
    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user =  userRepository.findById(id);

        if(user != null) {
            user.setName(userDTO.getName());
            user.setCpf(userDTO.getCpf());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            userRepository.update(user);
        }

        return convertToDTO(user);
    }

    @Override
    public UserDTO getPersonById(Long id) {
        User user = userRepository.findById(id);
        return convertToDTO(user);
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(id);
        }
    }

    private UserDTO convertToDTO(User user) {
        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setCpf(user.getCpf());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());

            return userDTO;
        }
        return null;
    }
}
