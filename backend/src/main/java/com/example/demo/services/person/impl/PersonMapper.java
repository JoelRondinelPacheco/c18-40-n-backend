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

        PersonInfoDTO personInfoDTO = new PersonInfoDTO();
        personInfoDTO.setId(person.getId());
        personInfoDTO.setName(person.getName());
        personInfoDTO.setLastName(personInfoDTO.getLastName());
        personInfoDTO.setUserName(person.getUsername());
        personInfoDTO.setPhoneNumber(person.getPhoneNumber());
        personInfoDTO.setEmail(person.getEmail());

        return personInfoDTO;
    }

    @Override
    public Person dtoToEntity(PersonInfoDTO personInfoDTO) {
        return null;
    }
}
