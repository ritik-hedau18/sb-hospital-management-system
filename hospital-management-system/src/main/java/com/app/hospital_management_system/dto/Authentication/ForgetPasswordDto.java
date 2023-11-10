package com.app.hospital_management_system.dto.Authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgetPasswordDto {

    private String email;
    private String password;
// minor tweak: performance check updates
}
