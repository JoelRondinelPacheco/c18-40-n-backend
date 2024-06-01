package com.example.demo.controller;
import com.example.demo.services.person.PersonCRUDService;
import com.example.demo.services.person.PersonRepository;
import com.example.demo.services.person.dto.CreatePersonDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PersonController {


    private final PersonCRUDService personService;

    @Autowired
    public PersonController(PersonCRUDService personService, PersonRepository personRepository) {
        this.personService = personService;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<PersonInfoDTO> createUser(@RequestBody CreatePersonDTO body) {
        PersonInfoDTO person = personService.createPerson(body);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<PersonInfoDTO>> getUsers(Pageable pageable) {
        Page<PersonInfoDTO> persons = personService.getPersons(pageable);
        return ResponseEntity.ok(persons);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<PersonInfoDTO> updateUser(@RequestBody PersonInfoDTO personInfoDTO){

        PersonInfoDTO person = personService.updatePerson(personInfoDTO);
        return  ResponseEntity.ok(person);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<PersonInfoDTO> deleteUser(@RequestBody PersonInfoDTO personInfoDTO){
        //TODO
        return ResponseEntity.ok(personInfoDTO);
    }

    @GetMapping("/id/{test}")
    public ResponseEntity<String> testEndpoint(@PathVariable String test) {
        return ResponseEntity.ok(test);
    }
}
