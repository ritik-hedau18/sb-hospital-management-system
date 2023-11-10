package com.app.hospital_management_system.dto.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private long contactNumber;
    private String address;
    private String admissionDate;
    private String bloodGroup;
    private String userName;
    private String hospitalSystemId;
}
