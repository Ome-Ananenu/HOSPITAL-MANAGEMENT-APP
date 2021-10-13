package com.ome.springbootcrudoperation.service;

import com.ome.springbootcrudoperation.entity.Doctor;
import com.ome.springbootcrudoperation.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService{


    @Autowired
    private DoctorRepo doctorRepo;


    //Add Doctors
    @Transactional
    @Override
    public Doctor createDoctor(Doctor doctor) {
        Doctor createdDoctor = new Doctor();
        createdDoctor.setFirstName(doctor.getFirstName());
        createdDoctor.setLastName(doctor.getLastName());
        createdDoctor.setAddress(doctor.getAddress());
        createdDoctor.setSpecialty(doctor.getSpecialty());
        createdDoctor.setPhoneNumber(doctor.getPhoneNumber());
        String id = UUID.randomUUID().toString();
        createdDoctor.setId(id);
        doctorRepo.save(createdDoctor);
        return createdDoctor;
    }

    //Get all Doctors
    @Transactional
    @Override
    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    //Get one doctor by id
    @Transactional
    @Override
    public Optional<Doctor> getDoctor(@PathVariable String id) {
        return doctorRepo.findById(id);
    }

    //Update a doctor
    @Transactional
    public Doctor updateDoctor(String id, Doctor doctor) {
        Doctor doctorFromDatabase = doctorRepo.findById(id).get();
        doctorFromDatabase.setFirstName(doctor.getFirstName());
        doctorFromDatabase.setLastName(doctor.getLastName());
        doctorFromDatabase.setAddress(doctor.getAddress());
        doctorFromDatabase.setSpecialty(doctor.getSpecialty());
        doctorFromDatabase.setPhoneNumber(doctor.getPhoneNumber());
        return doctorFromDatabase;
    }


    //Delete a doctor
    @Transactional
    @Override
    public String deleteDoctor(@PathVariable String id) {
        Doctor doctorFromDatabase = doctorRepo.findById(id).get();
        doctorRepo.delete(doctorFromDatabase);
        return "Doctor deleted successfully";
    }
}
