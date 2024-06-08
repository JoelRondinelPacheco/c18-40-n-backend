package com.example.demo.services.auth;

import com.example.demo.persistence.entities.Role;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.entities.UserCredentials;

public interface UserCredentialsService {
    UserCredentials newUserCredentials(User person, Role role, String encodedPassword);
}
