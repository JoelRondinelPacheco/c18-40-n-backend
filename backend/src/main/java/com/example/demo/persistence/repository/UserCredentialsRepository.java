package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.PersonCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends JpaRepository<PersonCredentials, Long> {

    Optional<PersonCredentials> findByPerson_Email(String email);
}
