package com.example.demo.services.auth;

import com.example.demo.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
}