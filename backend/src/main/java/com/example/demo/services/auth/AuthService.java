package com.example.demo.services.auth;

import com.example.demo.services.auth.dto.LoginRequest;
import com.example.demo.services.auth.dto.LoginResponse;
import com.example.demo.services.auth.dto.RegisterRequest;

public interface AuthService {
    LoginResponse login(LoginRequest body);

    String registerUser(RegisterRequest body);
}
