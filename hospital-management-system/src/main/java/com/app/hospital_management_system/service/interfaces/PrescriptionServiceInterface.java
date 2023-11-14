package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.Prescription.PrescriptionCreateDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionResponseDto;
import com.app.hospital_management_system.dto.Prescription.PrescriptionUpdateDto;

import java.util.List;

public interface PrescriptionServiceInterface {

    public PrescriptionResponseDto registerPrescription(int id, PrescriptionCreateDto dto);

    public PrescriptionResponseDto getPrescriptionById(int id);

    public List<PrescriptionResponseDto> getPrescriptionsByAppointmentId(int id);

    public List<PrescriptionResponseDto> getAllPrescriptions();

    public  PrescriptionResponseDto updatePrescription(int id, PrescriptionUpdateDto dto);

    public void deletePrescription(int id);
}
// minor tweak: performance check updates


// minor tweak: update verification rules and configs

// minor tweak: update verification rules and configs at 3362
