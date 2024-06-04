package com.example.demo.services.auth;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface JwtTokenService {

    String generateAuthToken(String username, Map<String, Object> extraClaims);
    String extractJwtFromRequest(HttpServletRequest request);
    String extractUsername(String jwt);
}
