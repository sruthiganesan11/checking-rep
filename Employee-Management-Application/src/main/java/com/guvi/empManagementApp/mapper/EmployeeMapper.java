package com.guvi.empManagementApp.mapper;


import com.guvi.empManagementApp.entities.Employee;

public class EmployeeMapper {
    public static com.guvi.empManagementApp.dto.EmployeeDto mapToEmployeeDto(Employee employee) {
        return new com.guvi.empManagementApp.dto.EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(com.guvi.empManagementApp.dto.EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
