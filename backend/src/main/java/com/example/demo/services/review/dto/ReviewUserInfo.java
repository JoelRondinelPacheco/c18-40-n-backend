package com.example.demo.services.review.dto;

import com.example.demo.persistence.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewUserInfo {
    public String getUsername(User user) {
        if (user.getName() != null) {
            return user.getName().concat(
                    user.getLastname()
            );
        }

        return user.getUsername();
    }
}
