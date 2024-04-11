package com.guvi.empManagementApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guvi.empManagementApp.entities.EmployeeDto;
import com.guvi.empManagementApp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private ObjectMapper objectMapper;
    private EmployeeDto employeeDto;

    @BeforeEach
    public void setup() {
        employeeDto = EmployeeDto.builder()
                .firstName("john")
                .lastName("doe")
                .email("john@gmail.com")
                .build();
    }
    @Test
    public void givenEmployee_whenCreateEmployee_thenReturnEmployee() throws Exception {
        given(employeeService.saveEmployee(any(com.guvi.empManagementApp.dto.EmployeeDto.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDto)));
        response.andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employeeDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employeeDto.getLastName())))
                .andExpect(jsonPath("$.email", is(employeeDto.getEmail())));

    }

}
