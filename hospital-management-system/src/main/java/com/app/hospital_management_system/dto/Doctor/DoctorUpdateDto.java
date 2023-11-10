package com.app.hospital_management_system.dto.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateDto {

    private String doctorName;
    private String specialization;
    private String qualification;
    private String experienceYears;
    private Long phoneNo;
    private String username;
    private String email;

}
