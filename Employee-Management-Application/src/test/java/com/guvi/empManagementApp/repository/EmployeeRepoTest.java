package com.guvi.empManagementApp.repository;

import com.guvi.empManagementApp.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = Employee.builder()
                .firstName("john")
                .lastName("doe")
                .email("john@gmail.com")
                .build();
    }

    @DisplayName("Test whether an Employee get saved in DB")
    @Test
    public void givenEmployee_whenSave_thenReturnSavedEmployee() {
        //given -> employee

        Employee savedEmployee = employeeRepo.save(employee);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public  void givenEmployeeList_whenFindAll_thenEmployeeList(){
        Employee employee1=Employee.builder()
                .firstName("Tinky")
                .lastName("Manisha")
                .email("tinky@gmail.com")
                .build();
        employeeRepo.save(employee);
        employeeRepo.save(employee1);

        List<Employee> employeeList = employeeRepo.findAll();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    @Test
    public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee() {
        employeeRepo.save(employee);
        Employee employeeDb = employeeRepo.findByEmail(employee.getEmail()).get();
        assertThat(employeeDb).isNotNull();


    }

    @Test
    public void givenEmployee_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        employeeRepo.save(employee);
        Employee savedEmployee = employeeRepo.findById(employee.getId()).get();
        savedEmployee.setEmail("john@gmail.com");
        Employee updatedEmployee = employeeRepo.save(savedEmployee);

        assertThat(updatedEmployee.getEmail()).isEqualTo("john@gmail.com");
    }

    @Test
    public void givenEmployee_whenDelete_thenRemoveEmployee() {
        employeeRepo.save(employee);
        employeeRepo.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepo.findById(employee.getId());
        assertThat(employeeOptional).isEmpty();
    }

}