package com.app.hospital_management_system.dto.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCreateDto {

    private String appointmentDate;
    private String appointmentTime;
    private String consultationType;
    private int roomNumber;
    private String appointmentStatus;
    private String bookingDate;
    private String remarks;
}
