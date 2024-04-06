package com.guvi.userManagementApp.service.impl;

import com.guvi.userManagementApp.dto.JwtAuthResponse;
import com.guvi.userManagementApp.dto.LoginRequestDto;
import com.guvi.userManagementApp.dto.RegisterDto;
import com.guvi.userManagementApp.entities.User;
import com.guvi.userManagementApp.exception.UserApiException;
import com.guvi.userManagementApp.repository.RoleRepo;
import com.guvi.userManagementApp.repository.UserSecurityRepo;
import com.guvi.userManagementApp.security.JwtUtil;
import com.guvi.userManagementApp.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private UserSecurityRepo userSecurityRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @Override
    public String register(RegisterDto registerDto) {
        // To check whether a user already exists with the same username
        if (userSecurityRepo.existsByUsername(registerDto.getUsername())) {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "UserName already exists");
        }

        if(userSecurityRepo.existsByEmail(registerDto.getEmail())) {
            throw new UserApiException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        User userSecurity =
        return null;
    }

    @Override
    public JwtAuthResponse login(LoginRequestDto loginRequestDto) {
        return null;
    }
}
