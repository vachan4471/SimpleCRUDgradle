package com.example.service.interfaces;

import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto getUser(long userId);
    UserResponseDto getUserByUsername(String username);
    UserResponseDto updateUsername(long userId, UserRequestDto requestDto);
    boolean deleteUsername(long userId);
}
