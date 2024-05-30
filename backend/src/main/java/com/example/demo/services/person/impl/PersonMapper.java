package com.example.demo.services.person.impl;

import com.example.demo.persistence.entities.Person;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("personMapper")
public class PersonMapper implements DtoMapper<PersonInfoDTO, Person> {

    @Override
    public PersonInfoDTO entityToDTO(Person person) {
        return null;
    }

    @Override
    public Person dtoToEntity(PersonInfoDTO personInfoDTO) {
        return null;
    }
}
