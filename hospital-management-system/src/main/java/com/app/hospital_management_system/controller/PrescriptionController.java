package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.Prescription.PrescriptionCreateDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionResponseDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionUpdateDto;
import com.app.hospital_management_system.service.interfaces.PrescriptionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionServiceInterface psi;

    @PostMapping("/save/{id}")
    public PrescriptionResponseDto registerPrescription(@PathVariable("id") int id, @RequestBody PrescriptionCreateDto dto) {
        return psi.registerPrescription(id, dto);
    }
    @GetMapping("/getById/{id}")
    public PrescriptionResponseDto getPrescriptionById(@PathVariable("id") int id) {
        return psi.getPrescriptionById(id);
    }
    @GetMapping("/getByAppointmentId/{id}")
    public List<PrescriptionResponseDto> getPrescriptionsByAppointmentId(@PathVariable("id") int id){
        return psi.getPrescriptionsByAppointmentId(id);
    }
    @GetMapping("/getAll")
    public List<PrescriptionResponseDto> getAllPrescriptions() {
        return psi.getAllPrescriptions();
    }
@PutMapping("/update/{id}")
    public  PrescriptionResponseDto updatePrescription(@PathVariable("id") int id, @RequestBody PrescriptionUpdateDto dto){
        return psi.updatePrescription(id, dto);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePrescription(@PathVariable("id") int id) {
        psi.deletePrescription(id);
        return "Prescription Deleted Successfully";
    }
}
