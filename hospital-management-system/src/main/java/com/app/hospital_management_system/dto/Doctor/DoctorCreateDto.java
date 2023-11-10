package com.app.hospital_management_system.dto.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorCreateDto {

    private String doctorName;
    private String specialization;
    private String qualification;
    private String experienceYears;
    private long phoneNo;
    private String email;
    private String joiningDate;
    private String username;
    private String password;

// minor tweak: performance check updates
}
