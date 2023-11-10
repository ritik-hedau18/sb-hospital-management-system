package com.app.hospital_management_system.dto.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientUpdateDto {

    private String patientName;
    private Integer age;
    private Long contactNumber;
    private String address;
    private String bloodGroup;
    private String userName;
}
