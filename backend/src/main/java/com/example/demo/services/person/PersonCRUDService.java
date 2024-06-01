package com.example.demo.services.person;

import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface PersonCRUDService {
    PersonInfoDTO createPerson(CreatePersonDTO person);
    PersonInfoDTO getPersonByEmail(String email);
    PersonInfoDTO updatePerson(PersonInfoDTO info);
    Page<PersonInfoDTO> getPersons(Pageable pageable);
    void delete(String email);
}
