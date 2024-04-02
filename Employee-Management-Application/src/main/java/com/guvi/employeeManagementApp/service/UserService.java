package com.guvi.employeeManagementApp.service;

import com.guvi.employeeManagementApp.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId,UserDto updatedUser);

    void deleteUser(Long userId);
}
