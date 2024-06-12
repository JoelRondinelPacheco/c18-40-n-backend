package com.example.demo.controller;

import com.example.demo.services.auth.AuthService;
import com.example.demo.services.auth.dto.LoginRequest;
import com.example.demo.services.auth.dto.LoginResponse;
import com.example.demo.services.auth.dto.RegisterRequest;
import com.example.demo.services.auth.dto.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest body) {
        System.out.println("permitio login");
        return ResponseEntity.ok(this.authService.login(body));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest body) {
        return ResponseEntity.ok(
                new RegisterResponse(
                this.authService.registerUser(body)
                ));
    }


}
