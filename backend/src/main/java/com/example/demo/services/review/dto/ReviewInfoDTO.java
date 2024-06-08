package com.example.demo.services.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewInfoDTO implements ReviewInfoQueryDTO {
    private Long id;
    private BigDecimal qualification;
    @Getter
    private String comment;
    private String username;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public BigDecimal getQualification() {
        return this.qualification;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
