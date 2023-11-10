package com.app.hospital_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    private String consultationType;
    private int roomNumber;
    private String appointmentStatus;
    private String bookingDate;
    private String remarks;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appointment")
    @JsonManagedReference
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonBackReference
    private Doctor doctor;
}
