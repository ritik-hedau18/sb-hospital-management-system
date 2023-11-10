package com.app.hospital_management_system.dto.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreateDto {

    private String patientName;
    private int age;
    private String gender;
    private long contactNumber;
    private String address;
    private String admissionDate;
    private String bloodGroup;
    private String userName;
    private String password;
}
