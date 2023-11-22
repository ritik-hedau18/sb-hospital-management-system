package com.app.hospital_management_system.controller;

import com.app.hospital_management_system.dto.Doctor.DoctorCreateDto;
import com.app.hospital_management_system.dto.Doctor.DoctorResponseDto;
import com.app.hospital_management_system.dto.Doctor.DoctorUpdateDto;
import com.app.hospital_management_system.service.interfaces.DoctorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorServiceInterface dsi;

    @PostMapping("/save/{id}")
    public DoctorResponseDto registerDoctor(@PathVariable("id") int id, @RequestBody DoctorCreateDto dto){
        return dsi.registerDoctor(id, dto);
    }

    @GetMapping("/getById/{id}")
    public DoctorResponseDto getDoctorById(@PathVariable("id") int id) {
        return dsi.getDoctorById(id);
    }

    @GetMapping("/getByName/{name}")
    public DoctorResponseDto getDoctorByName(@PathVariable("name") String name){
        return dsi.getDoctorByName(name);
    }

    @GetMapping("/getAll")
    public List<DoctorResponseDto> getAllDoctors(){
        return dsi.getAllDoctors();
    }

    @PutMapping("/update/{id}")
    public  DoctorResponseDto updateDoctor(@PathVariable("id") int id, @RequestBody DoctorUpdateDto dto){
        return dsi.updateDoctor(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id") int id){
        dsi.deleteDoctor(id);
        return "Doctor Deleted Successfully";
    }
// minor tweak: performance check updates
}
