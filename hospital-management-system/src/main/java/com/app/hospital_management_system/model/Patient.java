package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Setter
@Getter
@ToString(exclude = "password")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private long contactNumber;
    private String address;
    private String admissionDate;
    private String bloodGroup;
    private String userName;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    @JsonManagedReference
    private List<MedicalRecord> medicalRecords;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    @JsonManagedReference
    private List<Billing> billings;

    @ManyToOne
    @JoinColumn(name = "systemId")
    @JsonBackReference
    private HospitalSystem hospitalSystem;
}
