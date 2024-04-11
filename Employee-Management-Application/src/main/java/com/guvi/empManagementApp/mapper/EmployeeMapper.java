package com.guvi.empManagementApp.mapper;


import com.guvi.empManagementApp.entities.EmployeeDto;

public class EmployeeMapper {
    public static com.guvi.empManagementApp.dto.EmployeeDto mapToEmployeeDto(EmployeeDto employee) {
        return new com.guvi.empManagementApp.dto.EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static EmployeeDto mapToEmployee(com.guvi.empManagementApp.dto.EmployeeDto employeeDto) {
        return new EmployeeDto(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
