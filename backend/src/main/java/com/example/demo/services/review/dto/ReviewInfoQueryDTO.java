package com.example.demo.services.review.dto;

import com.example.demo.persistence.entities.User;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface ReviewInfoQueryDTO {
    Long getId();
    BigDecimal getQualification();
    String getObservations();
    @Value(("#{@ReviewUserInfo.getUsername(user)}"))
    String getUsername();
}
