package com.guvi.userManagementApp.service.impl;


import com.guvi.userManagementApp.dto.UserDto;
import com.guvi.userManagementApp.entities.User;
import com.guvi.userManagementApp.exception.ResourceNotFoundException;
import com.guvi.userManagementApp.mapper.UserMapper;
import com.guvi.userManagementApp.repository.UserRepo;
import com.guvi.userManagementApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepo.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException
                ("User Not exists with the given id " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException
                        ("User Not exists with the given id " + userId));

        user.setId(updatedUser.getId());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(user.getEmail());

        User updatedUserObj = userRepo.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("User Not exists with the given id " + userId));
        userRepo.deleteById(userId);
    }
}
