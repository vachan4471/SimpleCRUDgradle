package com.example.service.interfaces;

import com.example.dto.request.LoginRequestDto;
import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;

public interface RegisterLoginService {
    UserResponseDto register(UserRequestDto request);
    String Login(LoginRequestDto request);
}
