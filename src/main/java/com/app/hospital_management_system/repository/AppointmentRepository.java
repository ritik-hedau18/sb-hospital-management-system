package com.app.hospital_management_system.repository;
import com.app.hospital_management_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
}
// minor tweak: update verification rules and configs
