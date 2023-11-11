package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    public List<Appointment> findByDoctor_doctorId(int doctorId);
}
