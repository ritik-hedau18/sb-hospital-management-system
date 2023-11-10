package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;
    private String diagnosis;
    private String treatment;
    private String allergies;
    private String previousDiseases;
    private String testReports;
    private String recordDate;
    private String doctorRemarks;

    @ManyToOne
    @JoinColumn(name = "patientId")
    @JsonBackReference
    private Patient patient;
// minor tweak: performance check updates
}
