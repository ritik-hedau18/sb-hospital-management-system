package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.Billing.BillingCreateDto;
import com.app.hospital_management_system.dto.Billing.BillingResponseDto;
import com.app.hospital_management_system.dto.Billing.BillingUpdateDto;
import com.app.hospital_management_system.service.interfaces.BillingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingServiceInterface bsi;

    @PostMapping("/save/{id}")
    public BillingResponseDto registerBilling(@PathVariable("id") int patientId, @RequestBody BillingCreateDto dto) {
      return  bsi.registerBilling(patientId, dto);
    }
    @GetMapping("/getById/{id}")
    public BillingResponseDto getBillingById(@PathVariable("id") int id) {
        return bsi.getBillingById(id);
    }
    @GetMapping("/getByPatientId/{id}")
    public List<BillingResponseDto> getBillingByPatientId(@PathVariable("id") int patientId) {
        return bsi.getBillingByPatientId(patientId);
    }
    @GetMapping("/getAllBillings")
    public   List<BillingResponseDto> getAllBilling() {
        return bsi.getAllBilling();
    }
    @PutMapping("/update/{id}")
    public BillingResponseDto updateBilling(@PathVariable("id") int id, @RequestBody BillingUpdateDto dto)  {
        return bsi.updateBilling(id, dto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBillingById(@PathVariable("id") int id)  {
        bsi.deleteBillingById(id);
        return  "Billing Deleted Successfully";
    }

}
