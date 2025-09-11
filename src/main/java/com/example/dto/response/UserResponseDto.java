package com.example.dto.response;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserResponseDto {
    private long userId;
    private String username;
    private String email;
    private String password;
}
