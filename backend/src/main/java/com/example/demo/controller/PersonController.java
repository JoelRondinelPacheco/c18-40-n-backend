package com.example.demo.controller;
import com.example.demo.infra.exceptions.UserNotFound;
import com.example.demo.persistence.entities.User;
import jakarta.transaction.Transactional;


import com.example.demo.services.user.UserCRUDService;
import com.example.demo.services.user.dto.CreateUserDTO;
import com.example.demo.services.user.dto.UserInfoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class PersonController {



    private final UserCRUDService personService;

    @Autowired
    public PersonController(UserCRUDService personService) {
        this.personService = personService;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody CreateUserDTO body) {

        UserInfoDTO person = personService.createPerson(body);

        return ResponseEntity.ok(person);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<UserInfoDTO> updateUser(@RequestBody UserInfoDTO userInfoDTO){

        UserInfoDTO person = personService.updatePerson(userInfoDTO);
        return  ResponseEntity.ok(person);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Optional<User>> deleteUser(@RequestBody UserInfoDTO userInfoDTO){
        Optional<User> person = personService.getUserById(userInfoDTO.getId());

        return ResponseEntity.ok(person);
    }

    @GetMapping("/id/{test}")
    public ResponseEntity<Page<UserInfoDTO>> getUsers(Pageable pageable) {

            Page<UserInfoDTO> persons = this.personService.getPersons(pageable);
            return ResponseEntity.ok(persons);
    }

    @GetMapping("/id/SingleUser")
    public ResponseEntity<Optional<User>> getUser(UserInfoDTO userInfoDTO){
        Optional<User> user = this.personService.getUserById(userInfoDTO.getId());
        System.out.println(userInfoDTO.getId());
        System.out.println(user);




        if(user.isPresent()){
            return ResponseEntity.ok(user);
        }else{
            throw new UserNotFound("User not found with id " + userInfoDTO.getId());
        }
    }

    @GetMapping("/eventId/{test}")
    public ResponseEntity<String> testEndpoint(@PathVariable String test) {
        return ResponseEntity.ok(test);
    }
}
