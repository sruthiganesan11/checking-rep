package com.guvi.empManagementApp.repository;

import com.guvi.empManagementApp.entities.EmployeeDto;
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
    private EmployeeDto employeeDto;

    @BeforeEach
    public void setup() {
        employeeDto = EmployeeDto.builder()
                .firstName("john")
                .lastName("doe")
                .email("john@gmail.com")
                .build();
    }

    @DisplayName("Test whether an Employee get saved in DB")
    @Test
    public void givenEmployee_whenSave_thenReturnSavedEmployee() {
        //given -> employee

        EmployeeDto savedEmployee = employeeRepo.save(employeeDto);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public  void givenEmployeeList_whenFindAll_thenEmployeeList(){
        EmployeeDto employee1= EmployeeDto.builder()
                .firstName("Tinky")
                .lastName("Manisha")
                .email("tinky@gmail.com")
                .build();
        employeeRepo.save(employeeDto);
        employeeRepo.save(employee1);

        List<EmployeeDto> employeeList = employeeRepo.findAll();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    @Test
    public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee() {
        employeeRepo.save(employeeDto);
        EmployeeDto employeeDb = employeeRepo.findByEmail(employeeDto.getEmail()).get();
        assertThat(employeeDb).isNotNull();


    }

    @Test
    public void givenEmployee_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        employeeRepo.save(employeeDto);
        EmployeeDto savedEmployee = employeeRepo.findById(employeeDto.getId()).get();
        savedEmployee.setEmail("john@gmail.com");
        EmployeeDto updatedEmployee = employeeRepo.save(savedEmployee);

        assertThat(updatedEmployee.getEmail()).isEqualTo("john@gmail.com");
    }

    @Test
    public void givenEmployee_whenDelete_thenRemoveEmployee() {
        employeeRepo.save(employeeDto);
        employeeRepo.deleteById(employeeDto.getId());
        Optional<EmployeeDto> employeeOptional = employeeRepo.findById(employeeDto.getId());
        assertThat(employeeOptional).isEmpty();
    }

}