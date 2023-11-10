package com.app.hospital_management_system.dto.Billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingUpdateDto {

    private Double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String insuranceProvider;
    private Double discount;
    private Long receiptNumber;
}
