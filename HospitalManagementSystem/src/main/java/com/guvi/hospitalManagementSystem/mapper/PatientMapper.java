package com.guvi.hospitalManagementSystem.mapper;

import com.guvi.hospitalManagementSystem.dto.PatientDto;
import com.guvi.hospitalManagementSystem.entity.Patient;

public class PatientMapper {
    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(

                patient.getId(),
                patient.getPatientName(),
                patient.getContactNumber(),
                patient.getEmail(),
                patient.getAge(),
                patient.getMedicalHistory()

        );
    }

    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getPatientName(),
                patientDto.getContactNumber(),
                patientDto.getEmail(),
                patientDto.getAge(),
                patientDto.getMedicalHistory()
        );
    }
}
