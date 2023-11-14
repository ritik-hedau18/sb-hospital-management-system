package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.Billing.BillingCreateDto;
import com.app.hospital_management_system.dto.Billing.BillingResponseDto;
import com.app.hospital_management_system.dto.Billing.BillingUpdateDto;
import com.app.hospital_management_system.model.Billing;
import com.app.hospital_management_system.model.Patient;
import com.app.hospital_management_system.repository.BillingRepository;
import com.app.hospital_management_system.repository.PatientRepository;
import com.app.hospital_management_system.service.interfaces.BillingServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillingServiceImpl implements BillingServiceInterface {

    @Autowired
    private BillingRepository br;

    @Autowired
    private PatientRepository pr;

    @Autowired
    private ModelMapper mapper;

    @Override
    public BillingResponseDto registerBilling(int patientId, BillingCreateDto dto) {

        Patient patient = pr.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Billing billing = mapper.map(dto, Billing.class);
        billing.setPatient(patient);
        Billing save = br.save(billing);
        return mapper.map(save, BillingResponseDto.class);
    }

    @Override
    public BillingResponseDto getBillingById(int id) {

        Billing billing = br.findById(id).orElseThrow(() -> new RuntimeException("Billing not found"));
        return mapper.map(billing, BillingResponseDto.class);
    }

    @Override
    public List<BillingResponseDto> getBillingByPatientId(int patientId) {

       return br.findByPatient_PatientId(patientId)
               .stream()
               .map(billing -> mapper.map(billing, BillingResponseDto.class))
               .toList();
    }

    @Override
    public List<BillingResponseDto> getAllBilling() {

       return br.findAll()
               .stream()
               .map(billing -> mapper.map(billing, BillingResponseDto.class))
               .toList();
    }

    @Override
    public BillingResponseDto updateBilling(int id, BillingUpdateDto dto) {

        Billing billing = br.findById(id).orElseThrow(() -> new RuntimeException("Billing not found"));
        mapper.map(dto, billing);
        Billing save = br.save(billing);

        return mapper.map(save, BillingResponseDto.class);
    }

    @Override
    public void deleteBillingById(int id) {

        Billing billing = br.findById(id).orElseThrow(() -> new RuntimeException("Billing not found"));
        br.delete(billing);
    }
}
