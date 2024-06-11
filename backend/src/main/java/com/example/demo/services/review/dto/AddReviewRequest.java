package com.example.demo.services.review.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class AddReviewRequest {
    private BigDecimal qualification;
    private String comment;
    private Long socialEventId;
    private String userEmail;
}
