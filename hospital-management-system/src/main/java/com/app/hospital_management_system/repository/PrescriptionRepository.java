package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {

    public List<Prescription> findByAppointment_appointmentId  (Integer id);
}
