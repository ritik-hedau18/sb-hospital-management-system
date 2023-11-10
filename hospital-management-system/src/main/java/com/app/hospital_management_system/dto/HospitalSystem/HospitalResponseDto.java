package com.app.hospital_management_system.dto.HospitalSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponseDto {

    private int systemId;
    private String systemName;
    private String hospitalName;
    private String location;
    private String establishedYear;
    private long contactNo;
    private String supportEmail;
    private int totalDepartments;
    private String username;

}
