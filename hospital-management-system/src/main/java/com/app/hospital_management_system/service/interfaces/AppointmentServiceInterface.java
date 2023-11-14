package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.Appointment.AppointmentCreateDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentResponseDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentUpdateDto;

import java.util.List;

public interface AppointmentServiceInterface {

    public AppointmentResponseDto registerAppointment(int doctorId, AppointmentCreateDto dto);

    public AppointmentResponseDto getAppointmentById(int id);

    public List<AppointmentResponseDto> getAppointmentsByDoctorId(int doctorId);

    public List<AppointmentResponseDto> getAllAppointments();

    public  AppointmentResponseDto updateAppointment(int id, AppointmentUpdateDto dto);

    public void deleteAppointment(int id);
}
