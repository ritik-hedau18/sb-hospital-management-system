package com.app.hospital_management_system.dto.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionResponseDto {

    private int prescriptionId;
    private String medicinesName;
    private String dosage;
    private String duration;
    private String instructions;
    private String issuedDates;
    private String doctorNotes;
    private String refilStatus;
}
