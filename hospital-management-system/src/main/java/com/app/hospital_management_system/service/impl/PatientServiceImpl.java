package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.Patient.PatientCreateDto;
import com.app.hospital_management_system.dto.Patient.PatientResponseDto;
import com.app.hospital_management_system.dto.Patient.PatientUpdateDto;
import com.app.hospital_management_system.model.HospitalSystem;
import com.app.hospital_management_system.model.Patient;
import com.app.hospital_management_system.repository.HospitalSystemRepository;
import com.app.hospital_management_system.repository.PatientRepository;
import com.app.hospital_management_system.service.interfaces.PatientServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl  implements PatientServiceInterface {

    @Autowired
   private PatientRepository pr;

    @Autowired
 private HospitalSystemRepository hsr;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PatientResponseDto registerPatient(int id, PatientCreateDto dto) {

        HospitalSystem hospital = hsr.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        Patient patient = mapper.map(dto, Patient.class);
        patient.setHospitalSystem(hospital);
        Patient save = pr.save(patient);
        return mapper.map(save, PatientResponseDto.class);
    }

    @Override
    public PatientResponseDto getPatientById(int id) {

        Patient patient = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        return mapper.map(patient, PatientResponseDto.class);
    }

    @Override
    public PatientResponseDto getPatientByName(String name) {

        Patient patient = pr.findByPatientName(name).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        return mapper.map(patient, PatientResponseDto.class);
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {

        return  pr.findAll().stream().map(patient -> mapper.map(patient, PatientResponseDto.class)).toList();
    }

    @Override
    public PatientResponseDto updatePatient(int id, PatientUpdateDto dto) {

        Patient patient = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        mapper.map(dto, patient);
        Patient save = pr.save(patient);
        return mapper.map(save, PatientResponseDto.class);
    }

    @Override
    public void deletePatient(int id) {

        Patient patient = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        pr.delete(patient);
    }
}
