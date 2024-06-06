package com.example.demo.services.auth.impl;

import com.example.demo.persistence.entities.Role;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.entities.UserCredentials;
import com.example.demo.services.auth.AuthService;
import com.example.demo.services.auth.CustomUserDetailsService;
import com.example.demo.services.auth.RoleService;
import com.example.demo.services.auth.UserCredentialsService;
import com.example.demo.services.auth.dto.LoginRequest;
import com.example.demo.services.auth.dto.LoginResponse;
import com.example.demo.services.auth.dto.RegisterRequest;
import com.example.demo.services.user.RegisterUserUseCase;
import com.example.demo.services.user.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServiceImpl jwtTokenService;
    private final RegisterUserUseCase registerUserUseCase;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserCredentialsService userCredentialsService;
    private final RoleService roleService;

    @Value("${security.default.role}")
    private String DEFAULT_ROLE;

    @Autowired
    public AuthServiceImpl(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtTokenServiceImpl jwtTokenService, RegisterUserUseCase registerUserUseCase, BCryptPasswordEncoder passwordEncoder, UserCredentialsService userCredentialsService, RoleService roleService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.registerUserUseCase = registerUserUseCase;
        this.passwordEncoder = passwordEncoder;
        this.userCredentialsService = userCredentialsService;
        this.roleService = roleService;
    }

    @Override
    public LoginResponse login(LoginRequest body) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(body.email(), body.password());

        UserCredentials userCredentials = (UserCredentials) this.userDetailsService.loadUserByUsername(body.email());

        String jwt = this.jwtTokenService.generateAuthToken(
                userCredentials.getUsername(),
                this.generateExtraClaims(userCredentials)
                );

        return new LoginResponse(jwt);
    }

    @Override
    @Transactional
    public String registerUser(RegisterRequest body) {
        if (!this.validatePassword(body.password(), body.password())) {
            //todo throw ex
            return "Invalid passwords";
        }
        String encodedPassword = this.passwordEncoder.encode(body.password());

        CreateUserDTO userDTO = CreateUserDTO.builder()
                .userName(body.username())
                .email(body.email())
                .build();

        User user =  this.registerUserUseCase.register(userDTO);
        Role role = this.roleService.getByName(DEFAULT_ROLE);
        this.userCredentialsService.newUserCredentials(
                user,
                role,
                encodedPassword
        );

        return "Register ok";
    }

    private Map<String, Object> generateExtraClaims(UserCredentials userCredentials) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", userCredentials.getUsername());
        extraClaims.put("role", userCredentials.getRole().getName());
        extraClaims.put("authorities", userCredentials.getAuthorities());
        return extraClaims;
    }

    private boolean validatePassword(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }
}
