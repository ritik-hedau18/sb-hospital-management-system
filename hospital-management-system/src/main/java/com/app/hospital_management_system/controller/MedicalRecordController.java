package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordCreateDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordResponseDto;
import com.app.hospital_management_system.dto.MedicalRecord.MedicalRecordUpdateDTO;
import com.app.hospital_management_system.service.interfaces.MedicalRecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordServiceInterface msi;

    @PostMapping("/save/{id}")
    public MedicalRecordResponseDto registerMedicalRecord(@PathVariable("id") int patientId , @RequestBody MedicalRecordCreateDto dto) {
        return msi.registerMedicalRecord(patientId, dto);
    }
    @GetMapping("/getById/{id}")
    public MedicalRecordResponseDto findMedicalRecordById(@PathVariable("id") int id) {
        return msi.findMedicalRecordById(id);
    }
    @GetMapping("/getByPatientId/{id}")
    public List<MedicalRecordResponseDto> findMedicalRecordByPatientId(@PathVariable("id") int patientId) {
        return msi.findMedicalRecordByPatientId(patientId);
    }
    @GetMapping("/getAll")
    public List<MedicalRecordResponseDto> getAllMedicalRecords() {
        return msi.getAllMedicalRecords();
    }
    @PutMapping("/update/{id}")
    public MedicalRecordResponseDto updateMedicalRecord(@PathVariable("id") int id, @RequestBody MedicalRecordUpdateDTO dto) {
        return msi.updateMedicalRecord(id, dto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteMedicalRecordById(@PathVariable("id") int id) {
        msi.deleteMedicalRecordById(id);
        return "Medical Record Deleted Successfully";
    }

}
