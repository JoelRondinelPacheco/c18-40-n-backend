package com.example.demo.services.user.impl;

import com.example.demo.persistence.entities.User;
import com.example.demo.services.user.UserUtils;
import org.springframework.stereotype.Service;

@Service
public class UserUtilsImpl implements UserUtils {

    @Override
    public String getUsername(User user) {

        if (user.getName() != null){
            return user.getName().concat(
                    user.getLastname());
        }
        return user.getUsername();
    }
}
