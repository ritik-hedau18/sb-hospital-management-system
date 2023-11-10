package com.app.hospital_management_system.model;

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
public class HospitalSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int systemId;
    private String systemName;
    private String hospitalName;
    private String location;
    private String establishedYear;
    private long contactNo;
    private String supportEmail;
    private int totalDepartments;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalSystem")
    @JsonManagedReference
    private List<Doctor> doctor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalSystem")
    @JsonManagedReference
    private List<Patient> patient;
}
