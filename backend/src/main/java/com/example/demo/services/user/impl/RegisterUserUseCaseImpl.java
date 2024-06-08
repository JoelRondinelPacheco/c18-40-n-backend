package com.example.demo.services.user.impl;

import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.user.RegisterUserUseCase;
import com.example.demo.services.user.dto.CreateUserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(CreateUserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        return this.userRepository.save(user);
    }
}
