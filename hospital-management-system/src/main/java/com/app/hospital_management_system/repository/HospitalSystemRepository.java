package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.HospitalSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalSystemRepository extends JpaRepository<HospitalSystem,Integer> {

    public Optional< HospitalSystem> findByHospitalName (String hospitalName);

    HospitalSystem findByUsername(String username);
// minor tweak: performance check updates
// minor tweak: performance check updates
}
