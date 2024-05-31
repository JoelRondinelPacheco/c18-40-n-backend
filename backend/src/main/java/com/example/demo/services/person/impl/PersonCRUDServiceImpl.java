package com.example.demo.services.person.impl;

import com.example.demo.persistence.entities.Person;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.person.PersonCRUDService;
import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonCRUDServiceImpl implements PersonCRUDService {


    private UserRepository userRepository;
    @Qualifier("personMapper")
    private DtoMapper<PersonInfoDTO, Person> mapper;

    @Autowired
    public PersonCRUDServiceImpl(UserRepository userRepository, DtoMapper<PersonInfoDTO, Person> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public PersonInfoDTO createPerson(CreatePersonDTO person) {
        return null;
    }

    @Override
    public PersonInfoDTO getPersonByEmail(String email) {

        return null;
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
