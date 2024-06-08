package com.example.demo.services.review.dto;


import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface ReviewInfoQueryDTO {
    Long getId();
    BigDecimal getQualification();
    String getComment();
    @Value(("#{@reviewUserInfo.getUsername(target.user)}"))
    String getUsername();
    /*
    @Value("#{target.user.name}")
    String getName();
    @Value("#{target.user.lastname}")
    String getLastname();
    @Value("#{target.user.username}")
    String getUsername();*/

}
