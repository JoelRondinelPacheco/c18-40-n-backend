package com.example.demo.services.person.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonBaseDTO {
    private String name;
    private String lastName;
    private String userName;
    private String address;
    private Long phoneNumber;
    private String email;
}
