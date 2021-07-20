package com.example.udemy_project1.repository;

import com.example.udemy_project1.entities.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalsRepository  extends JpaRepository<Hospitals,Long> {
    List<Hospitals> findByPincode(String pincode);
    Hospitals findByHospitalUsername(String username);
}
