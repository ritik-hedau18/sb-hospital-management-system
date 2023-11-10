package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Setter
@Getter
@ToString(exclude = "password")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    private String specialization;
    private String qualification;
    private String experienceYears;
    private long phoneNo;
    private String email;
    private String joiningDate;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    @JsonManagedReference
    private List<Appointment> appointment;

    @ManyToOne
    @JoinColumn(name = "systemId")
    @JsonBackReference
    private HospitalSystem hospitalSystem;
// minor tweak: performance check updates
}
