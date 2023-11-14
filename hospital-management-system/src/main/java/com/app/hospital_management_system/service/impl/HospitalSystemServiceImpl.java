package com.app.hospital_management_system.service.impl;

import com.app.hospital_management_system.dto.HospitalSystem.HospitalCreateDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalResponseDto;
import com.app.hospital_management_system.dto.HospitalSystem.HospitalUpdateDto;
import com.app.hospital_management_system.model.HospitalSystem;
import com.app.hospital_management_system.repository.HospitalSystemRepository;
import com.app.hospital_management_system.service.JwtService;
import com.app.hospital_management_system.service.interfaces.HospitalSystemServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import com.app.hospital_management_system.model.Users;
import com.app.hospital_management_system.repository.UserRepository;

@Service
public class HospitalSystemServiceImpl implements HospitalSystemServiceInterface {

    @Autowired
    HospitalSystemRepository hsr;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtService jwt;

    @Override
    public HospitalResponseDto registerHospital(HospitalCreateDto dto) {

        HospitalSystem hospital = mapper.map(dto, HospitalSystem.class);
        String encodedPassword = passwordEncoder.encode(hospital.getPassword());
        hospital.setPassword(encodedPassword);
        HospitalSystem save = hsr.save(hospital);

        Users user = new Users();
        user.setUsername(hospital.getUsername());
        user.setPassword(encodedPassword);
        user.setRole("ADMIN");
        userRepository.save(user);

        return mapper.map(save, HospitalResponseDto.class);
    }



    @Override
    public HospitalResponseDto getHospitalById(int id) {

        HospitalSystem hospital = hsr.findById(id).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        return mapper.map(hospital, HospitalResponseDto.class);
    }

    @Override
    public HospitalResponseDto getHospitalByName(String name) {

        HospitalSystem hospital = hsr.findByHospitalName(name).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        return mapper.map(hospital, HospitalResponseDto.class);
    }

    @Override
    public List<HospitalResponseDto> getAllHospitals() {

        List<HospitalSystem> list = hsr.findAll();
        return list.stream().map(hospitalSystem -> mapper.map(hospitalSystem, HospitalResponseDto.class)).toList();
    }

    @Override
    public HospitalResponseDto updateHospital(int id, HospitalUpdateDto dto) {

        HospitalSystem hospital = hsr.findById(id).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        mapper.map(dto, hospital);
        HospitalSystem hospitalSystem = hsr.save(hospital);
        return mapper.map(hospitalSystem, HospitalResponseDto.class);
    }

    @Override
    public void deleteHospital(int id) {

        hsr.findById(id).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        hsr.deleteById(id);
    }

    @Override
    public String verify(HospitalSystem hospital) {
        Authentication authentication =
                manager.authenticate(new UsernamePasswordAuthenticationToken(hospital.getUsername(), hospital.getPassword()));

        if (authentication.isAuthenticated()) {
            return  jwt.generateToken(hospital.getUsername());
        } return "Failure";

    }
}
