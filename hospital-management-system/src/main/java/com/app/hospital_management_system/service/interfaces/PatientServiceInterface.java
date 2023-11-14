package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.Patient.PatientCreateDto;
import com.app.hospital_management_system.dto.Patient.PatientResponseDto;
import com.app.hospital_management_system.dto.Patient.PatientUpdateDto;

import java.util.List;

public interface PatientServiceInterface {

    public PatientResponseDto registerPatient(int id, PatientCreateDto dto);

    public PatientResponseDto getPatientById(int id);

    public PatientResponseDto getPatientByName(String name);

    public List<PatientResponseDto> getAllPatients();

    public  PatientResponseDto updatePatient(int id, PatientUpdateDto dto);

    public void deletePatient(int id);
}
