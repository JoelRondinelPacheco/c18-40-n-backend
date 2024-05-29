package com.example.demo.services.person.impl;

import com.example.demo.services.person.PersonCRUDService;
import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PersonCRUDServiceImpl implements PersonCRUDService {
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
