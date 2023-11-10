package com.app.hospital_management_system.dto.MedicalRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordCreateDto {

    private String diagnosis;
    private String treatment;
    private String allergies;
    private String previousDiseases;
    private String testReports;
    private String recordDate;
    private String doctorRemarks;
}
