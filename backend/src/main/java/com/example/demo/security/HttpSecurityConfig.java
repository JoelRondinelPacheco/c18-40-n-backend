package com.example.demo.security;

import com.example.demo.security.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {


    private final AuthenticationProvider daoAuthenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public HttpSecurityConfig(AuthenticationProvider daoAuthenticationProvider, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        SecurityFilterChain filterChain = http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionManagementConfig -> sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/auth/**").permitAll()
                        //todo event publicos
                        //search/filter publico
                        .anyRequest().authenticated())
                .build();

        return filterChain;
    }
}
