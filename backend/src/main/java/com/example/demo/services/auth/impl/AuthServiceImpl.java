package com.example.demo.services.auth.impl;

import com.example.demo.persistence.entities.UserCredentials;
import com.example.demo.services.auth.AuthService;
import com.example.demo.services.auth.CustomUserDetailsService;
import com.example.demo.services.auth.dto.LoginRequest;
import com.example.demo.services.auth.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServiceImpl jwtTokenService;

    @Autowired
    public AuthServiceImpl(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtTokenServiceImpl jwtTokenService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public LoginResponse login(LoginRequest body) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        this.authenticationManager.authenticate(authentication);

        UserCredentials userCredentials = (UserCredentials) this.userDetailsService.loadUserByUsername(body.email());
        String jwt = this.jwtTokenService.generateAuthToken(
                userCredentials.getUsername(),
                this.generateExtraClaims(userCredentials)
                );

        return new LoginResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(UserCredentials userCredentials) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", userCredentials.getUsername());
        extraClaims.put("role", userCredentials.getRole().name());
        extraClaims.put("authorities", userCredentials.getAuthorities());
        return extraClaims;
    }
}
