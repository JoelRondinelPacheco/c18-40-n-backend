package com.example.demo.services.auth.impl;

import com.example.demo.services.auth.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${security.jwt.expiration-in-minutes.auth}")
    private Long AUTH_EXPIRATION_IN_MINUTES;

    private final String SECRET_KEY="CAMBIAR A STRING EN APPLICATION PROPERTIES";

    @Override
    public String generateAuthToken(String username, Map<String, Object> extraClaims) {
        Date issuedAt = new Date();
        Date expiration = this.generateExpirationDate(issuedAt, AUTH_EXPIRATION_IN_MINUTES);
        return Jwts.builder()
                .header()
                    .type("JWT")
                    .and()
                .subject(username)
                .issuedAt(issuedAt)
                .expiration(expiration)
                .claims(extraClaims)
                .signWith(
                        this.getSecretKey()
                )
                .compact();
    }

    @Override
    public String extractJwtFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        return authorizationHeader.split(" ")[1];
    }

    @Override
    public String extractUsername(String jwt) {
        return null;
    }

    private Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private Date generateExpirationDate(Date issuedAt, Long expirationInMinutes) {
        return new Date(issuedAt.getTime() + (expirationInMinutes * 60 * 1000));
    }
}
