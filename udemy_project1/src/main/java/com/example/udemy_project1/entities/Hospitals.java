package com.example.udemy_project1.entities;


import javax.persistence.*;

@Entity
@Table(name="hospitals")
public class Hospitals {

    @Id
    @GeneratedValue
    private Long hospitalId;

    @Column(name = "HOSPITAL_USERNAME",length = 50,nullable = false, unique = false)
    private String hospitalUsername;

    @Column(name = "HOSPITAL_NAME",length = 50,nullable = false, unique = false)
    private String name;

    @Column(name = "SPUTNIK_AVAILABLE",nullable = false, unique = false)
    private int sputnik_available;

    @Column(name = "COVAXIN_AVAILABLE",nullable = false, unique = false)
    private int covaxin_available;

    @Column(name = "COVISHIELD_AVAILABLE",nullable = false, unique = false)
    private int covishield_available;

    @Column(name = "ADDRESS",length = 50,nullable = false, unique = false)
    private String address;

    @Column(name = "PINCODE",length = 50,nullable = false, unique = false)
    private String pincode;

    public Hospitals() {
    }

    public Hospitals(Long hospitalId, String hospitalUsername, String name, int sputnik_available, int covaxin_available, int covishield_available, String address, String pincode) {
        this.hospitalId = hospitalId;
        this.hospitalUsername = hospitalUsername;
        this.name = name;
        this.sputnik_available = sputnik_available;
        this.covaxin_available = covaxin_available;
        this.covishield_available = covishield_available;
        this.address = address;
        this.pincode = pincode;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalUsername() {
        return hospitalUsername;
    }

    public void setHospitalUsername(String hospitalUsername) {
        this.hospitalUsername = hospitalUsername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSputnik_available() {
        return sputnik_available;
    }

    public void setSputnik_available(int sputnik_available) {
        this.sputnik_available = sputnik_available;
    }

    public int getCovaxin_available() {
        return covaxin_available;
    }

    public void setCovaxin_available(int covaxin_available) {
        this.covaxin_available = covaxin_available;
    }

    public int getCovishield_available() {
        return covishield_available;
    }

    public void setCovishield_available(int covishield_available) {
        this.covishield_available = covishield_available;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
