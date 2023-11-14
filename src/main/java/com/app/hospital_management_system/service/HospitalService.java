package com.app.hospital_management_system.service;
import com.app.hospital_management_system.model.Patient;
import com.app.hospital_management_system.model.Appointment;
import com.app.hospital_management_system.repository.PatientRepository;
import com.app.hospital_management_system.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HospitalService {
    private final PatientRepository patientRepo;
    private final AppointmentRepository appRepo;

    public HospitalService(PatientRepository patientRepo, AppointmentRepository appRepo) {
        this.patientRepo = patientRepo;
        this.appRepo = appRepo;
    }

    public Patient registerPatient(Patient p) {
        return patientRepo.save(p);
    }

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public Appointment schedule(Appointment app) {
        app.setStatus("SCHEDULED");
        return appRepo.save(app);
    }

    public List<Appointment> getAppointments(Long patientId) {
        return appRepo.findByPatientId(patientId);
    }
}