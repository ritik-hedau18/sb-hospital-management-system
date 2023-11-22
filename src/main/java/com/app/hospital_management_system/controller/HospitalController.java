package com.app.hospital_management_system.controller;
import com.app.hospital_management_system.model.Patient;
import com.app.hospital_management_system.model.Appointment;
import com.app.hospital_management_system.service.HospitalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
    private final HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return service.getPatients();
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient p) {
        return service.registerPatient(p);
    }

    @PostMapping("/appointments")
    public Appointment addApp(@RequestBody Appointment app) {
        return service.schedule(app);
    }

    @GetMapping("/patients/{patientId}/appointments")
    public List<Appointment> getApps(@PathVariable Long patientId) {
        return service.getAppointments(patientId);
    }
}