package com.example.demo.services.auth;

import com.example.demo.services.auth.dto.LoginRequest;
import com.example.demo.services.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest body);
}
