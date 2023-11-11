package com.app.hospital_management_system.repository;


import com.app.hospital_management_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public Optional<Doctor> findBydoctorName(String name);

    Doctor findByUsername(String username);

}
