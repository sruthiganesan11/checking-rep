package com.guvi.userManagementApp.mapper;


import com.guvi.userManagementApp.dto.EmployeeDto;
import com.guvi.userManagementApp.entities.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToUserDto(Employee user) {
        return new EmployeeDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static Employee mapToUser(EmployeeDto userDto) {
        return new Employee(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
