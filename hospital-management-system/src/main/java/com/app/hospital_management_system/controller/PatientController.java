package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.Patient.PatientCreateDto;
import com.app.hospital_management_system.dto.Patient.PatientResponseDto;
import com.app.hospital_management_system.dto.Patient.PatientUpdateDto;
import com.app.hospital_management_system.service.interfaces.PatientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceInterface psi;

    @PostMapping("/save/{id}")
    public PatientResponseDto registerPatient(@PathVariable("id") int id, @RequestBody  PatientCreateDto dto) {
       return  psi.registerPatient(id, dto);
    }
    @GetMapping("/getById/{id}")
    public PatientResponseDto getPatientById(@PathVariable("id") int id) {
        return psi.getPatientById(id);
    }
    @GetMapping("/getByName/{name}")
    public PatientResponseDto getPatientByName(@PathVariable("name") String name) {
        return psi.getPatientByName(name);
    }
    @GetMapping("/getAll")
    public List<PatientResponseDto> getAllPatients() {
        return psi.getAllPatients();
    }
    @PutMapping("/update/{id}")
    public  PatientResponseDto updatePatient(@PathVariable("id") int id, @RequestBody PatientUpdateDto dto) {
        return psi.updatePatient(id, dto);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        psi.deletePatient(id);
        return "Patient has been deleted";
    }

// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs
