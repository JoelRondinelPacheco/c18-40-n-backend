package com.example.demo.services.socialevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SocialEventBaseDTO {
    //si
    private String eventName;
    private Date startDate;
    private String details;
    private BigDecimal price;
    private Long audienceCapacity;

    //nuevo
    private Date finishDate;

    //lugar
    private String placeName;
    private String address;
    private String city;

    private String contactInfo;
    private boolean published;

}
