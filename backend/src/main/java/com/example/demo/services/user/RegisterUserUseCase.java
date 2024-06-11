package com.example.demo.services.user;

import com.example.demo.persistence.entities.User;
import com.example.demo.services.user.dto.CreateUserDTO;

public interface RegisterUserUseCase {
    User register(CreateUserDTO user);
}
