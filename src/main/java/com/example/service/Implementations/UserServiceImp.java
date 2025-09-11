package com.example.service.Implementations;

import com.example.dto.mapper.UserMapper;
import com.example.dto.request.UserRequestDto;
import com.example.dto.response.UserResponseDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.interfaces.UserService;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto getUser(long userId) {
        return userMapper.toResponse(
                userRepo.findById(userId).orElseThrow(
                        ()-> new EntityNotFoundException("User with userId:"+userId+" Not Found")
                )
        );
    }

    @Override
    public UserResponseDto getUserByUsername(String username) {
        return userMapper.toResponse(
                userRepo.findByUsername(username).orElseThrow(
                        ()-> new EntityNotFoundException("User with userId:"+username+" Not Found")
                )
        );
    }

    @Override
    public UserResponseDto updateUsername(long userId, UserRequestDto requestDto) {
        if(!userRepo.existsById(userId)) {
            throw new EntityNotFoundException("User with userID:" + userId + " Not Found");
        }
        User updatingUser = userMapper.toEntity(requestDto);
        updatingUser.setUserId(userId);
        userRepo.save(updatingUser);
        return userMapper.toResponse(updatingUser);
    }

    @Override
    public boolean deleteUsername(long userId) {
        if(!userRepo.existsById(userId)) {
            throw new EntityNotFoundException("User with userID:" + userId + " Not Found");
        }
        userRepo.deleteById(userId);
        return true;
    }
}
