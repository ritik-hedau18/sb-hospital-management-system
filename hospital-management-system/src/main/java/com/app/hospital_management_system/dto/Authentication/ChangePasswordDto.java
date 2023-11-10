package com.app.hospital_management_system.dto.Authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {

    private String oldPassword;
    private String newPassword;
    public String confirmPassword;
}

// minor tweak: update verification rules and configs
