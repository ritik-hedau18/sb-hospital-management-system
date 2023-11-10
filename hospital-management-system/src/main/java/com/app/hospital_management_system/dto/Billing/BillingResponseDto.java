package com.app.hospital_management_system.dto.Billing;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingResponseDto {

    private int billId;
    private int patientId;
    private String billDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String insuranceProvider;
    private double discount;
    private long receiptNumber;
}

// minor tweak: update verification rules and configs
