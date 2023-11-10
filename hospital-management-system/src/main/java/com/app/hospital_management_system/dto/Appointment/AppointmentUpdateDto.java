package com.app.hospital_management_system.dto.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateDto {

    private String appointmentDate;
    private String appointmentTime;
    private String consultationType;
    private Integer roomNumber;
    private String appointmentStatus;
    private String remarks;

}
