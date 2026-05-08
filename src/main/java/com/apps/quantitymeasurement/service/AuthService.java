package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.*;
import com.apps.quantitymeasurement.entity.Role;
import com.apps.quantitymeasurement.entity.User;
import com.apps.quantitymeasurement.repository.UserRepository;
import com.apps.quantitymeasurement.security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder
            passwordEncoder;

    private final AuthenticationManager
            authenticationManager;

    private final JwtService jwtService;

    private final org.springframework.security.core.userdetails
            .UserDetailsService userDetailsService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            org.springframework.security.core.userdetails
                    .UserDetailsService userDetailsService
    ) {

        this.userRepository =
                userRepository;

        this.passwordEncoder =
                passwordEncoder;

        this.authenticationManager =
                authenticationManager;

        this.jwtService =
                jwtService;

        this.userDetailsService =
                userDetailsService;
    }

    public String register(
            RegisterRequest request
    ) {

        if (userRepository.existsByEmail(
                request.getEmail()
        )) {

            throw new RuntimeException(
                    "Email already registered"
            );
        }

        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(
                        request.getPassword()
                ),
                Role.ROLE_USER
        );

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponse login(
            AuthRequest request
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        request.getEmail()
                );

        String token =
                jwtService.generateToken(
                        userDetails
                );

        return new AuthResponse(token);
    }
}