package com.guvi.empManagementApp.repository;


import com.guvi.empManagementApp.entities.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<EmployeeDto, Long> {

    Optional<EmployeeDto> findByEmail(String email);
}
