package com.example.demo.persistence.utils;

import com.example.demo.persistence.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewUserInfo {
    String getUsername(User user) {
        if (!user.getName().isBlank()) {
            return user.getName().concat(
                    user.getLastname()
            );
        }

        return user.getUsername();
    }
}
