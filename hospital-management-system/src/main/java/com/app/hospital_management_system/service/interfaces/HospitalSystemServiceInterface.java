package com.app.hospital_management_system.service.interfaces;

import com.app.hospital_management_system.dto.HospitalSystem.HospitalCreateDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalResponseDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalUpdateDto;
import com.app.hospital_management_system.model.HospitalSystem;

import java.util.List;

public interface HospitalSystemServiceInterface {

   public  HospitalResponseDto registerHospital(HospitalCreateDto dto);

    public HospitalResponseDto getHospitalById(int id);

    public HospitalResponseDto getHospitalByName(String name);

    public List<HospitalResponseDto> getAllHospitals();

    public  HospitalResponseDto updateHospital(int id, HospitalUpdateDto dto);

    public void deleteHospital(int id);

  public  String verify(HospitalSystem hospital);
}
