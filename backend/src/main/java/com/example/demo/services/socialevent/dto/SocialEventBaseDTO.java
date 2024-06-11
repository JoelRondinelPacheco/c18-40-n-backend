package com.example.demo.services.socialevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocialEventBaseDTO {
    private String name;
    private String address;
    private Date programatedDate;
    private String contactInfo;
    private String details;
    private BigDecimal price;
    private boolean published;
    private Long maxGuests;
}
