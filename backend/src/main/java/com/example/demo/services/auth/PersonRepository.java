package com.example.demo.services.person;

import com.example.demo.persistence.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
    Person findByName(String name);
}
