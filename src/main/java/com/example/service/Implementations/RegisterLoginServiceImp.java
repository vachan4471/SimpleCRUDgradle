package com.example.service.Implementations;

import com.example.dto.mapper.UserMapper;
import com.example.dto.request.LoginRequestDto;
import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.interfaces.PasswordService;
import com.example.service.interfaces.RegisterLoginService;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class RegisterLoginServiceImp implements RegisterLoginService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final PasswordService passwordService;

    @Override
    public UserResponseDto register(UserRequestDto request) {
        User savingUser = userMapper.toEntity(request);
        if(userRepo.existsByUsername(savingUser.getUsername())){
            throw new EntityExistsException("Username: "+savingUser.getUsername()+" Already Exists");
        }
        //saving the password in encoded manner.
        savingUser.setPassword(passwordService.encodePassword(savingUser.getPassword()));
        User savedUser = userRepo.save(savingUser);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public String Login(LoginRequestDto request) {
        User savedUser = userRepo.findByUsername(request.getUsername()).orElseThrow(
                ()-> new EntityNotFoundException("User with username:"+request.getUsername()+" Not Found! Register first")
        );
        if(passwordService.verifyPassword(request.getPassword(), savedUser.getPassword())){
            throw new IllegalArgumentException("Password:"+request.getPassword()+" is wrong");
        }
        return "Generate Token here";
    }
}
