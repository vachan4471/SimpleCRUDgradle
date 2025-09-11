package com.example.dto.mapper;

import com.example.dto.request.LoginRequestDto;
import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;
import com.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jsr330")
public interface UserMapper {
    User toEntity(UserRequestDto request);
    UserResponseDto toResponse(User user);
    void updateToEntityFromDto(UserResponseDto response, @MappingTarget User user);
}
