package com.example.demo.services.auth.dto;

public record LoginResponse(String authToken, String role, String username) {
}
