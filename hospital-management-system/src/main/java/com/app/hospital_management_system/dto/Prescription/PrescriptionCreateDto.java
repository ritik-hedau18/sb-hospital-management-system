package com.app.hospital_management_system.dto.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionCreateDto {

    private String medicinesName;
    private String dosage;
    private String duration;
    private String instructions;
    private String issuedDates;
    private String doctorNotes;
    private String refilStatus;
}

// minor tweak: update verification rules and configs
