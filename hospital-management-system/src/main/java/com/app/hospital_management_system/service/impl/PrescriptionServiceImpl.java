package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.Prescription.PrescriptionCreateDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionResponseDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionUpdateDto;
import com.app.hospital_management_system.model.Appointment;
import com.app.hospital_management_system.model.Prescription;
import com.app.hospital_management_system.repository.AppointmentRepository;
import com.app.hospital_management_system.repository.PrescriptionRepository;
import com.app.hospital_management_system.service.interfaces.PrescriptionServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionServiceInterface {

    @Autowired
  private  PrescriptionRepository pr;

    @Autowired
    private  AppointmentRepository ar;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PrescriptionResponseDto registerPrescription(int id, PrescriptionCreateDto dto) {

        Appointment appointment = ar.findById(id).orElseThrow(() -> new RuntimeException("Appointment Not Found"));
        Prescription prescription = mapper.map(dto, Prescription.class);
        prescription.setAppointment(appointment);
        Prescription save = pr.save(prescription);
        return mapper.map(save, PrescriptionResponseDto.class);
    }

    @Override
    public PrescriptionResponseDto getPrescriptionById(int id) {

        Prescription prescription = pr.findById(id).orElseThrow(() -> new RuntimeException("Prescription Not Found"));
        return mapper.map(prescription, PrescriptionResponseDto.class);
    }

    @Override
    public List<PrescriptionResponseDto> getPrescriptionsByAppointmentId(int id) {

         ar.findById(id).orElseThrow(() -> new RuntimeException("Appointment Not Found"));
        return  pr.findByAppointment_appointmentId(id)
                .stream()
                .map(prescription -> mapper.map(prescription, PrescriptionResponseDto.class))
                .toList();
    }

    @Override
    public List<PrescriptionResponseDto> getAllPrescriptions() {

        return pr.findAll().stream().map(prescription -> mapper.map(prescription, PrescriptionResponseDto.class)).toList();
    }

    @Override
    public PrescriptionResponseDto updatePrescription(int id, PrescriptionUpdateDto dto) {

        Prescription prescription = pr.findById(id).orElseThrow(() -> new RuntimeException("Prescription Not Found"));
        mapper.map(dto, prescription);
        Prescription save = pr.save(prescription);
        return mapper.map(save, PrescriptionResponseDto.class);
    }

    @Override
    public void deletePrescription(int id) {

        Prescription prescription = pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription Not Found"));

        Appointment appointment = prescription.getAppointment();
        appointment.setPrescription(null);
        ar.save(appointment);

        pr.delete(prescription);
    }
// minor tweak: performance check updates
}
