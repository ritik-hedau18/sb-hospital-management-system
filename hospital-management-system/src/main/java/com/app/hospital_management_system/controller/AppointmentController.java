package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.Appointment.AppointmentCreateDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentResponseDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentUpdateDto;
import com.app.hospital_management_system.service.interfaces.AppointmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceInterface asi;

    @PostMapping("/save/{id}")
    public AppointmentResponseDto registerAppointment(@PathVariable("id") int doctorId, @RequestBody AppointmentCreateDto dto) {
        return asi.registerAppointment(doctorId, dto);
    }

    @GetMapping("/getById/{id}")
    public AppointmentResponseDto getAppointmentById(@PathVariable("id") int id) {
        return asi.getAppointmentById(id);
    }
    @GetMapping("/getByDoctorId/{id}")
    public List<AppointmentResponseDto> getAppointmentsByDoctorId(@PathVariable("id") int doctorId)  {
        return asi.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/getAll")
    public List<AppointmentResponseDto> getAllAppointments() {
        return asi.getAllAppointments();
    }

    @PutMapping("/update/{id}")
    public  AppointmentResponseDto updateAppointment(@PathVariable("id") int id,  @RequestBody AppointmentUpdateDto dto) {
        return asi.updateAppointment(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") int id) {
        asi.deleteAppointment(id);
        return "Appointment has been deleted";
    }
}
