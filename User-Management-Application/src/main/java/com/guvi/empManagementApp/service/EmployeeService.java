package com.guvi.userManagementApp.service;


import com.guvi.userManagementApp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createUser(EmployeeDto userDto);

    EmployeeDto getUserById(Long userId);

    List<EmployeeDto> getAllUsers();

    EmployeeDto updateUser(Long userId, EmployeeDto updatedUser);

    void deleteUser(Long userId);
}
