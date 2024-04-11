package com.guvi.empManagementApp.service.impl;


import com.guvi.empManagementApp.entities.EmployeeDto;
import com.guvi.empManagementApp.exception.EmailAlreadyExistException;
import com.guvi.empManagementApp.exception.ResourceNotFoundException;
import com.guvi.empManagementApp.mapper.EmployeeMapper;
import com.guvi.empManagementApp.repository.EmployeeRepo;
import com.guvi.empManagementApp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public com.guvi.empManagementApp.dto.EmployeeDto saveEmployee(com.guvi.empManagementApp.dto.EmployeeDto employeeDto) {

        Optional<EmployeeDto> optionalEmployee = employeeRepo.findByEmail(employeeDto.getEmail());

        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }

        EmployeeDto employee = EmployeeMapper.mapToEmployee(employeeDto);
        EmployeeDto savedEmployee = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public com.guvi.empManagementApp.dto.EmployeeDto getEmployeeById(Long employeeId) {

        EmployeeDto employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Employee", "id", employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<com.guvi.empManagementApp.dto.EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employees = employeeRepo.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public com.guvi.empManagementApp.dto.EmployeeDto updateEmployee(Long employeeId, com.guvi.empManagementApp.dto.EmployeeDto updatedEmployee) {
        EmployeeDto employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Employee", "id", employeeId));

        Optional<EmployeeDto> optionalEmployee = employeeRepo.findByEmail(updatedEmployee.getEmail());

        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        EmployeeDto updatedEmployeeObj = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        EmployeeDto employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Employee", "id", employeeId));
        employeeRepo.deleteById(employeeId);
    }
}
