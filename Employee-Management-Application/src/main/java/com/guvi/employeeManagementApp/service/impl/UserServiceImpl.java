package com.guvi.employeeManagementApp.service.impl;

import com.guvi.employeeManagementApp.dto.UserDto;
import com.guvi.employeeManagementApp.entities.User;
import com.guvi.employeeManagementApp.exception.ResourceNotFoundException;
import com.guvi.employeeManagementApp.mapper.UserMapper;
import com.guvi.employeeManagementApp.repository.UserRepo;
import com.guvi.employeeManagementApp.service.UserService;
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
