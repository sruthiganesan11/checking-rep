package com.guvi.userManagementApp.repository;


import com.guvi.userManagementApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
}
