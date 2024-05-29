package com.example.demo.controller;

import com.example.demo.services.person.PersonCRUDService;
import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PersonController {

    private PersonCRUDService personService;

    @PostMapping
    public ResponseEntity<PersonInfoDTO> createUser(@RequestBody CreatePersonDTO body) {
        PersonInfoDTO person = this.personService.createPerson(body);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<Page<PersonInfoDTO>> getUsers(Pageable pageable) {
        Page<PersonInfoDTO> persons = this.personService.getPersons(pageable);

        return ResponseEntity.ok(persons);
    }

    @GetMapping("/id/{test}")
    public ResponseEntity<String> testEndpoint(@PathVariable String test) {
        return ResponseEntity.ok(test);
    }
}
