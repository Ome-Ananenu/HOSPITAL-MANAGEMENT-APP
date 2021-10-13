package com.ome.springbootcrudoperation.service;
import java.util.*;

import com.ome.springbootcrudoperation.entity.Patient;
import com.ome.springbootcrudoperation.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import javax.validation.Valid;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    //Add Patients
    @Transactional
    @Override
    public Patient createPatient(Patient patient) {
        Patient createdPatient = new Patient();
        createdPatient.setFirstName(patient.getFirstName());
        createdPatient.setLastName(patient.getLastName());
        createdPatient.setAddress(patient.getAddress());
        createdPatient.setDateOfBirth(patient.getDateOfBirth());
        createdPatient.setPhoneNumber(patient.getPhoneNumber());
        createdPatient.setOccupation(patient.getOccupation());
        String id = UUID.randomUUID().toString();
        createdPatient.setId(id);
        patientRepo.save(createdPatient);
        return createdPatient;
    }

    //Get all Patients
    @Transactional
    @Override
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    //Get one patient by id
    @Transactional
    @Override
    public Optional<Patient> getPatient(@PathVariable String id) {
        return patientRepo.findById(id);
    }

    //Update a patient
    @Transactional
    public Patient updatePatient(String id, Patient patient) {
        Patient patientFromDatabase = patientRepo.findById(id).get();
        patientFromDatabase.setFirstName(patient.getFirstName());
        patientFromDatabase.setLastName(patient.getLastName());
        patientFromDatabase.setAddress(patient.getAddress());
        patientFromDatabase.setDateOfBirth(patient.getDateOfBirth());
        patientFromDatabase.setPhoneNumber(patient.getPhoneNumber());
        patientFromDatabase.setOccupation(patient.getOccupation());
        return patientFromDatabase;
    }


    //Delete a patient
    @Transactional
    @Override
    public String deletePatient(@PathVariable String id) {
        Patient patientFromDatabase = patientRepo.findById(id).get();
        patientRepo.delete(patientFromDatabase);
        return "Patient deleted successfully";
    }
}