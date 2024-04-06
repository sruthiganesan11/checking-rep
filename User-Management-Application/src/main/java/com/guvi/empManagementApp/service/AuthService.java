package com.guvi.userManagementApp.service;

import com.guvi.userManagementApp.dto.JwtAuthResponse;
import com.guvi.userManagementApp.dto.LoginRequestDto;
import com.guvi.userManagementApp.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginRequestDto loginRequestDto);
}
