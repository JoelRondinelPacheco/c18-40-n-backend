package com.example.demo.services.user.impl;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.user.UserCRUDService;
import com.example.demo.services.user.dto.CreateUserDTO;
import com.example.demo.services.user.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCRUDServiceImpl implements UserCRUDService {


    private UserRepository userRepository;
    @Qualifier("personMapper")
    private DtoMapper<UserInfoDTO, User> mapper;

    @Autowired
    public UserCRUDServiceImpl(UserRepository userRepository, DtoMapper<UserInfoDTO, User> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserInfoDTO createPerson(CreateUserDTO person) {
        return null;
    }

    @Override
    public UserInfoDTO getUserDTOByEmail(String email) {

        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public UserInfoDTO updatePerson(UserInfoDTO info) {
        return null;
    }

    @Override
    public Page<UserInfoDTO> getPersons(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(this.mapper::entityToDTO);
    }

    @Override
    public void delete(String email) {

    }
}
