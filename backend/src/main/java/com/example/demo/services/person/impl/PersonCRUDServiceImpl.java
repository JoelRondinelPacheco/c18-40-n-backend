package com.example.demo.services.person.impl;

import com.example.demo.persistence.entities.Person;
import com.example.demo.services.person.PersonCRUDService;
import com.example.demo.services.person.PersonRepository;
import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonCRUDServiceImpl implements PersonCRUDService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonCRUDServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @Override
    public PersonInfoDTO createPerson(CreatePersonDTO person) {

        Person user = new Person();

        user.setName(person.getName());
        user.setLastname(person.getLastName());
        user.setUsername(person.getUserName());
        user.setAddress(person.getAddress());
        user.setPhoneNumber(person.getPhoneNumber());
        user.setPassword(person.getPassword());
        user.setEmail(person.getEmail());

        Person savedPerson = personRepository.save(user);
        return new PersonInfoDTO(savedPerson.getId(), savedPerson.getName(), savedPerson.getEmail());
    }

    @Override
    public PersonInfoDTO getPersonByEmail(String email) {

        Person user = personRepository.findByEmail(email);
        return new PersonInfoDTO(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public PersonInfoDTO updatePerson(PersonInfoDTO info) {
        return null;
    }

    @Override
    public Page<PersonInfoDTO> getPersons(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String email) {

    }
}
