package com.app.hospital_management_system.repository;

import com.app.hospital_management_system.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository  extends JpaRepository<MedicalRecord,Integer> {

    public List<MedicalRecord> findByPatient_PatientId(Integer patientId);
}
