package com.example.demo.services.socialevent.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateSocialEventDTO extends SocialEventBaseDTO {
    //TODO COORDINAR DATOS QUE SE VAN A RECIBIR DESDE EL FRONT
    private List<Long> categoriesId;
    private String organizerEmail;
}
