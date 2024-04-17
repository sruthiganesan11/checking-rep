package com.guvi.hospitalManagementSystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;

    private String patientName;

    private String contactNumber;

    private String email;

    private int age;

    private String medicalHistory;
}
