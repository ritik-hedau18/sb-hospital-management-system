package com.app.hospital_management_system.dto.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDto {

    private int appointmentId;
    private int doctorId;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String consultationType;
    private int roomNumber;
    private String appointmentStatus;
    private String bookingDate;
    private String remarks;
}
