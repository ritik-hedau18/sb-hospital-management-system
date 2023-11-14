package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.Appointment.AppointmentCreateDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentResponseDto;
import com.app.hospital_management_system.dto.Appointment.AppointmentUpdateDto;
import com.app.hospital_management_system.model.Appointment;
import com.app.hospital_management_system.model.Doctor;
import com.app.hospital_management_system.repository.AppointmentRepository;
import com.app.hospital_management_system.repository.DoctorRepository;
import com.app.hospital_management_system.service.interfaces.AppointmentServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentServiceInterface {

    @Autowired
  private  AppointmentRepository ar;

    @Autowired
  private  DoctorRepository dr;

    @Autowired
  private  ModelMapper mapper;

    @Override
    public AppointmentResponseDto registerAppointment(int doctorId, AppointmentCreateDto dto) {

        Doctor doctor = dr.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        Appointment appointment = mapper.map(dto, Appointment.class);
        appointment.setDoctor(doctor);
        Appointment saved = ar.save(appointment);
        return mapper.map(saved, AppointmentResponseDto.class);
    }

    @Override
    public AppointmentResponseDto getAppointmentById(int id) {

        Appointment appointment = ar.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return mapper.map(appointment, AppointmentResponseDto.class);
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentsByDoctorId(int doctorId) {

        dr.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return ar.findByDoctor_doctorId(doctorId)
                .stream()
                .map(appointment -> mapper.map(appointment, AppointmentResponseDto.class))
                .toList();
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {

        return ar.findAll().stream().map((appointment -> mapper.map(appointment, AppointmentResponseDto.class))).toList();
    }

    @Override
    public AppointmentResponseDto updateAppointment(int id, AppointmentUpdateDto dto) {

        Appointment appointment = ar.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        mapper.map(dto, appointment);
        Appointment saved = ar.save(appointment);
        return mapper.map(saved, AppointmentResponseDto.class);
    }

    @Override
    public void deleteAppointment(int id) {

        Appointment appointment = ar.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        ar.delete(appointment);
    }
// minor tweak: performance check updates
// minor tweak: performance check updates
}
