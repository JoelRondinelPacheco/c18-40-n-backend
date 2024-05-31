package com.example.demo.services.person.impl;

import com.example.demo.persistence.entities.Person;
import com.example.demo.persistence.entities.PersonCredentials;
import com.example.demo.persistence.repository.UserCredentialsRepository;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.person.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserCredentialsRepository userCredentialRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UserCredentialsRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonCredentials user = this.userCredentialRepository.findByPerson_Email(username).orElseThrow(() -> new UsernameNotFoundException("Credenciales invalidas"));
        return user;
    }
}
