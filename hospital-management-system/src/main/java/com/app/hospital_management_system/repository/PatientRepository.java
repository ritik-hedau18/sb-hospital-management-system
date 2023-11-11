package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository  extends JpaRepository<Patient,Integer> {

public Optional<Patient> findByPatientName(String name);
}
