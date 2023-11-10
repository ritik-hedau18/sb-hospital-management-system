package com.app.hospital_management_system.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String status; // SCHEDULED, COMPLETED
}