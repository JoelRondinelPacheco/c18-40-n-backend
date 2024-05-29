package com.example.demo.services.socialevent.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateSocialEventDTO extends SocialEventBaseDTO {
    //TODO COORDINAR DATOS QUE SE VAN A RECIBIR DESDE EL FRONT
    private List<String> categoriesId;
    private String organizerEmail;
}