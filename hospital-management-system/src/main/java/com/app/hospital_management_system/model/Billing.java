package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    private String billDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String insuranceProvider;
    private double discount;
    private long receiptNumber;

    @ManyToOne
    @JoinColumn(name = "patientId")
    @JsonBackReference
    private Patient patient;
}
