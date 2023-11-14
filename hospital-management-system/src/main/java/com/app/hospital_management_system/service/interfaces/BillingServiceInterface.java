package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.Billing.BillingCreateDto;
import com.app.hospital_management_system.dto.Billing.BillingResponseDto;
import com.app.hospital_management_system.dto.Billing.BillingUpdateDto;

import java.util.List;

public interface BillingServiceInterface {

    public BillingResponseDto registerBilling(int patientId, BillingCreateDto dto);
    public BillingResponseDto getBillingById(int id);
    public List<BillingResponseDto> getBillingByPatientId(int patientId);
    public   List<BillingResponseDto> getAllBilling();
    public BillingResponseDto updateBilling(int id, BillingUpdateDto dto);
    public void deleteBillingById(int id);
}
