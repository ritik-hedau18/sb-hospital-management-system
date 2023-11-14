package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordCreateDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordResponseDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordUpdateDTO;

import java.util.List;

public interface MedicalRecordServiceInterface {

    public MedicalRecordResponseDto registerMedicalRecord(int patientId , MedicalRecordCreateDto dto);
    public MedicalRecordResponseDto findMedicalRecordById(int id);
    public List<MedicalRecordResponseDto> findMedicalRecordByPatientId(int patientId);
    public List<MedicalRecordResponseDto> getAllMedicalRecords();
    public MedicalRecordResponseDto updateMedicalRecord(int id, MedicalRecordUpdateDTO dto);
    public void deleteMedicalRecordById(int id);

}
