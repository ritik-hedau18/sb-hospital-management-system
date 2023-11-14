package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.Doctor.DoctorCreateDto;
import com.app.hospital_management_system.dto.Doctor.DoctorResponseDto;
import com.app.hospital_management_system.dto.Doctor.DoctorUpdateDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalCreateDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalResponseDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalUpdateDto;

import java.util.List;

public interface DoctorServiceInterface {

    public DoctorResponseDto registerDoctor(int id, DoctorCreateDto dto);

    public DoctorResponseDto getDoctorById(int id);

    public DoctorResponseDto getDoctorByName(String name);

    public List<DoctorResponseDto> getAllDoctors();

    public  DoctorResponseDto updateDoctor(int id, DoctorUpdateDto dto);

    public void deleteDoctor(int id);
}

