package com.example.demo.services.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePersonDTO extends PersonBaseDTO {
    private String password;

}
