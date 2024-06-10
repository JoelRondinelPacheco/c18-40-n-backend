package com.example.demo.services.auth.dto;

public record RegisterRequest(String username, String email, String password, String repeatedPassword) {
}
