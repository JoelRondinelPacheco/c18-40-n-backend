package com.example.demo.services.user.impl;

import com.example.demo.persistence.entities.User;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.user.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("personMapper")
public class PersonMapper implements DtoMapper<UserInfoDTO, User> {

    @Override
    public UserInfoDTO entityToDTO(User user) {

        UserInfoDTO personInfoDTO = new UserInfoDTO();
        personInfoDTO.setId(user.getId());
        personInfoDTO.setName(user.getName());
        personInfoDTO.setLastName(personInfoDTO.getLastName());
        personInfoDTO.setUserName(user.getUsername());
        personInfoDTO.setPhoneNumber(user.getPhoneNumber());
        personInfoDTO.setEmail(user.getEmail());

        return personInfoDTO;
    }

    @Override
    public User dtoToEntity(UserInfoDTO personInfoDTO) {
        return null;
    }
}
