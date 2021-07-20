package com.example.udemy_project1.services;


import com.example.udemy_project1.entities.Hospitals;
import com.example.udemy_project1.repository.HospitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalsService {

    @Autowired
    private HospitalsRepository hospitalsRepository;

    public Hospitals createHospital(Hospitals hospital){
        return hospitalsRepository.save(hospital);
    }

    public List<Hospitals> getAllHospitals(){
        return hospitalsRepository.findAll();
    }

    public Hospitals getHospitalByUsername(String username){
        return hospitalsRepository.findByHospitalUsername(username);
    }
    public List<Hospitals> getHospitalsByPincode(String pincode){
        return hospitalsRepository.findByPincode(pincode);
    }
    public Hospitals updateHospitalById(Long id, Hospitals hospital){
        hospital.setHospitalId(id);
        return hospitalsRepository.save(hospital);
    }

}
