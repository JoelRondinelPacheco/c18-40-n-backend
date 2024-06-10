package com.example.demo.services.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserBaseDTO {
    private String name;
    private String lastName;
    private String userName;
    private String address;
    private Long phoneNumber;
    private String email;
}
