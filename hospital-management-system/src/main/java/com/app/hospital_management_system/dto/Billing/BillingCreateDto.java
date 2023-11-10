package com.app.hospital_management_system.dto.Billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingCreateDto {

    private String billDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String insuranceProvider;
    private double discount;
    private long receiptNumber;
}

// minor tweak: update verification rules and configs
