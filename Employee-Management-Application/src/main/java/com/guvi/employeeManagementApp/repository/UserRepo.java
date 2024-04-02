package com.guvi.employeeManagementApp.repository;

import com.guvi.employeeManagementApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
