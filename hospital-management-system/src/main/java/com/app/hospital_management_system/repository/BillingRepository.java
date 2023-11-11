package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository  extends JpaRepository<Billing,Integer> {

    public List<Billing> findByPatient_PatientId(Integer id);
}
