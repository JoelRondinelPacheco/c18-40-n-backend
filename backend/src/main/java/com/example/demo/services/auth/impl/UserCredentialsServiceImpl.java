package com.example.demo.services.auth.impl;

import com.example.demo.persistence.entities.Role;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.entities.UserCredentials;
import com.example.demo.persistence.repository.UserCredentialsRepository;
import com.example.demo.services.auth.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserCredentialsServiceImpl(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @Override
    public UserCredentials newUserCredentials(User person, Role role, String password) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUser(person);
        userCredentials.setPassword(password);
        userCredentials.setRole(role);
        userCredentials.setAccountNonExpired(true);
        userCredentials.setAccountNonLocked(true);
        userCredentials.setCredentialsNonExpired(true);
        userCredentials.setEnabled(true);
        return this.userCredentialsRepository.save(userCredentials);
    }
}
