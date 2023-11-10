package com.app.hospital_management_system.dto.HospitalSystem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalCreateDto {

    private String systemName;
    private String hospitalName;
    private String location;
    private String establishedYear;
    private long contactNo;
    private String supportEmail;
    private int totalDepartments;
    private String username;
    private String password;
}
