package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordCreateDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordResponseDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordUpdateDTO;
import com.app.hospital_management_system.model.MedicalRecord;
import com.app.hospital_management_system.model.Patient;
import com.app.hospital_management_system.repository.MedicalRecordRepository;
import com.app.hospital_management_system.repository.PatientRepository;
import com.app.hospital_management_system.service.interfaces.MedicalRecordServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalRecordServiceImpl  implements MedicalRecordServiceInterface {

    @Autowired
    private MedicalRecordRepository mr;

    @Autowired
    private PatientRepository pr;

    @Autowired
    private ModelMapper mapper;

    @Override
    public MedicalRecordResponseDto registerMedicalRecord(int patientId, MedicalRecordCreateDto dto) {

        Patient patient = pr.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        MedicalRecord medicalRecord = mapper.map(dto, MedicalRecord.class);
        medicalRecord.setPatient(patient);
        MedicalRecord save = mr.save(medicalRecord);
        return mapper.map(save, MedicalRecordResponseDto.class);
    }

    @Override
    public MedicalRecordResponseDto findMedicalRecordById(int id) {

        MedicalRecord medicalRecord = mr.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
        return mapper.map(medicalRecord, MedicalRecordResponseDto.class);
    }

    @Override
    public List<MedicalRecordResponseDto> findMedicalRecordByPatientId(int patientId) {

        return mr.findByPatient_PatientId(patientId)
                .stream()
                .map(medicalRecord -> mapper.map(medicalRecord, MedicalRecordResponseDto.class))
                .toList();
    }

    @Override
    public List<MedicalRecordResponseDto> getAllMedicalRecords() {

        return mr.findAll()
                .stream()
                .map(medicalRecord -> mapper.map(medicalRecord, MedicalRecordResponseDto.class))
                .toList();
    }

    @Override
    public MedicalRecordResponseDto updateMedicalRecord(int id, MedicalRecordUpdateDTO dto) {

        MedicalRecord medicalRecord = mr.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
        mapper.map(dto, medicalRecord);
        MedicalRecord save = mr.save(medicalRecord);
        return mapper.map(save, MedicalRecordResponseDto.class);
    }

    @Override
    public void deleteMedicalRecordById(int id) {

        MedicalRecord medicalRecord = mr.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
        mr.delete(medicalRecord);
    }
}
