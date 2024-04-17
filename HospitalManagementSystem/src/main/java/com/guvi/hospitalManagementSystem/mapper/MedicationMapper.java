package com.guvi.hospitalManagementSystem.mapper;

import com.guvi.hospitalManagementSystem.dto.MedicationDto;
import com.guvi.hospitalManagementSystem.entity.Medication;

public class MedicationMapper {
    public static MedicationDto mapToMedicationDto(Medication medication) {
        return new MedicationDto(

                medication.getId(),
                medication.getPatientName(),
                medication.getAppointmentDate(),
                medication.getMedicineName(),
                medication.getDescription()

        );
    }

    public static Medication mapToMedication(MedicationDto medicationDto) {
        return new Medication(

                medicationDto.getId(),
                medicationDto.getPatientName(),
                medicationDto.getAppointmentDate(),
                medicationDto.getMedicineName(),
                medicationDto.getDescription()
        );
    }
}