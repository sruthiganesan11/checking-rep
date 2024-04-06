package com.guvi.userManagementApp.service.impl;


import com.guvi.userManagementApp.dto.EmployeeDto;
import com.guvi.userManagementApp.entities.Employee;
import com.guvi.userManagementApp.exception.EmailAlreadyExistException;
import com.guvi.userManagementApp.exception.ResourceNotFoundException;
import com.guvi.userManagementApp.mapper.EmployeeMapper;
import com.guvi.userManagementApp.repository.EmployeeRepo;
import com.guvi.userManagementApp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo userRepo;

    @Override
    public EmployeeDto createUser(EmployeeDto userDto) {

        Optional<Employee> optionalUser = userRepo.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }

        Employee user = EmployeeMapper.mapToUser(userDto);
        Employee savedUser = userRepo.save(user);

        return EmployeeMapper.mapToUserDto(savedUser);
    }

    @Override
    public EmployeeDto getUserById(Long userId) {

        Employee user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User", "id", userId));
        return EmployeeMapper.mapToUserDto(user);
    }

    @Override
    public List<EmployeeDto> getAllUsers() {
        List<Employee> users = userRepo.findAll();
        return users.stream().map(EmployeeMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateUser(Long userId, EmployeeDto updatedUser) {
        Employee user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User", "id", userId));

        Optional<Employee> optionalUser = userRepo.findByEmail(updatedUser.getEmail());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());

        Employee updatedUserObj = userRepo.save(user);
        return EmployeeMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {

        Employee user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User", "id", userId));
        userRepo.deleteById(userId);
    }
}
