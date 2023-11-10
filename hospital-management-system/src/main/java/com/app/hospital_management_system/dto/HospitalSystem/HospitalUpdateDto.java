package com.app.hospital_management_system.dto.HospitalSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalUpdateDto {

    private String hospitalName;
    private String location;
    private Long contactNo;
    private String supportEmail;
    private Integer totalDepartments;
    private String username;

}
