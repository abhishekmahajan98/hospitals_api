package com.example.udemy_project1.controllers;

import com.example.udemy_project1.entities.Hospitals;
import com.example.udemy_project1.services.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    private HospitalsService hospitalsService;


    @PostMapping("/hospitals")
    public Hospitals createHospital(@RequestBody Hospitals hospital){
        return hospitalsService.createHospital(hospital);
    }

    @GetMapping("/hospitals")
    public List<Hospitals> getAllHospitals(){
        return  hospitalsService.getAllHospitals();
    }

    @GetMapping("/hospitals/{username}")
    public Hospitals getHospitalByUsername(@PathVariable("username") String username){
        return hospitalsService.getHospitalByUsername(username);
    }

    @PutMapping("/hospitals/{id}")
    public Hospitals updateHospitalById(@PathVariable("id") Long id,@RequestBody Hospitals hospital ){
        return hospitalsService.updateHospitalById(id,hospital);
    }

    @GetMapping("/hospitals/pincode/{pincode}")
    public List<Hospitals> getHospitalsByPincode(@PathVariable("pincode") String pincode){
        return hospitalsService.getHospitalsByPincode(pincode);
    }
}
