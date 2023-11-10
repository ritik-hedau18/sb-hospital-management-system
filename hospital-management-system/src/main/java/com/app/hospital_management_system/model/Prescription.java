package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;
    private String medicinesName;
    private String dosage;
    private String duration;
    private String instructions;
    private String issuedDates;
    private String doctorNotes;
    private String refilStatus;

    @OneToOne
    @JoinColumn(name = "appointmentId")
    @JsonBackReference
    private Appointment appointment;
}
