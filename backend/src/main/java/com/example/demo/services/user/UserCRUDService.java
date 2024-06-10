package com.example.demo.services.user;

import com.example.demo.persistence.entities.User;
import com.example.demo.services.user.dto.CreateUserDTO;
import com.example.demo.services.user.dto.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCRUDService {
    UserInfoDTO createPerson(CreateUserDTO person);
    UserInfoDTO getUserDTOByEmail(String email);
    UserInfoDTO getUserById(Long id);
    User getUserByEmail(String email);
    UserInfoDTO updatePerson(UserInfoDTO info);
    Page<UserInfoDTO> getPersons(Pageable pageable);
    void delete(String email);
}
