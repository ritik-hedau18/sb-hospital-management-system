package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.HospitalSystem.HospitalCreateDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalResponseDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalUpdateDto;
import com.app.hospital_management_system.model.HospitalSystem;
import com.app.hospital_management_system.service.interfaces.HospitalSystemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/hospital")
public class HospitalSystemController {

    @Autowired
    HospitalSystemServiceInterface hsi;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/save")
    public HospitalResponseDto registerHospital(@RequestBody HospitalCreateDto dto) {
        return hsi.registerHospital(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody HospitalSystem hospital) {

        return    hsi.verify(hospital);
    }

    @GetMapping("/getById/{id}")
    public HospitalResponseDto getHospitalById(@PathVariable("id") int id) {
        return hsi.getHospitalById(id);
    }

    @GetMapping("/getByName/{name}")
    public HospitalResponseDto getHospitalByName(@PathVariable("name") String name) {
        return hsi.getHospitalByName(name);
    }

    @GetMapping("/getAll")
    public List<HospitalResponseDto> getAllHospitals() {
        return hsi.getAllHospitals();
    }

    @PutMapping("/update/{id}")
    public  HospitalResponseDto updateHospital(@PathVariable("id") int id, @RequestBody HospitalUpdateDto dto) {
        return  hsi.updateHospital(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHospital(@PathVariable("id") int id) {
        hsi.deleteHospital(id);
        return "Hospital deleted successfully";
    }

}

// minor tweak: update verification rules and configs

// minor tweak: update verification rules and configs at 7344
