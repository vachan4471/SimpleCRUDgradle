package com.example.service;

import com.example.dto.request.LoginRequestDto;
import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto request);
    String Login(LoginRequestDto request);
}
