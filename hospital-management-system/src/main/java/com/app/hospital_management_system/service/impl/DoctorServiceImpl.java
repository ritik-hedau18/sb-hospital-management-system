package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.Doctor.DoctorCreateDto;
import com.app.hospital_management_system.dto.Doctor.DoctorResponseDto;
import com.app.hospital_management_system.dto.Doctor.DoctorUpdateDto;
import com.app.hospital_management_system.model.Doctor;
import com.app.hospital_management_system.model.HospitalSystem;
import com.app.hospital_management_system.repository.DoctorRepository;
import com.app.hospital_management_system.repository.HospitalSystemRepository;
import com.app.hospital_management_system.service.interfaces.DoctorServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl  implements DoctorServiceInterface {

    @Autowired
    private DoctorRepository dr;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HospitalSystemRepository hsr;

    @Override
    public DoctorResponseDto registerDoctor(int id, DoctorCreateDto dto) {

        HospitalSystem hospital = hsr.findById(id).orElseThrow(() -> new RuntimeException("Hospital  Not Found"));
        Doctor doctor = mapper.map(dto, Doctor.class);
        doctor.setHospitalSystem(hospital);
        Doctor save = dr.save(doctor);
        return  mapper.map(save, DoctorResponseDto.class);
    }

    @Override
    public DoctorResponseDto getDoctorById(int id) {

        Doctor doctor = dr.findById(id).orElseThrow(() -> new RuntimeException("Doctor Not Found"));
        return mapper.map(doctor, DoctorResponseDto.class);
    }

    @Override
    public DoctorResponseDto getDoctorByName(String name) {

        Doctor doctor = dr.findBydoctorName(name).orElseThrow(() -> new RuntimeException("Doctor Not Found"));
        return mapper.map(doctor, DoctorResponseDto.class);
    }

    @Override
    public List<DoctorResponseDto> getAllDoctors() {

        return dr.findAll().stream().map(doctor -> mapper.map(doctor, DoctorResponseDto.class)).toList();
    }

    @Override
    public DoctorResponseDto updateDoctor(int id, DoctorUpdateDto dto) {

        Doctor doctor = dr.findById(id).orElseThrow(() -> new RuntimeException("Doctor Not Found"));
        mapper.map(dto, doctor);
        Doctor save = dr.save(doctor);
        return mapper.map(save, DoctorResponseDto.class);
    }

    @Override
    public void deleteDoctor(int id) {

        Doctor doctor = dr.findById(id).orElseThrow(() -> new RuntimeException("Doctor Not Found"));
        dr.delete(doctor);
    }
}
