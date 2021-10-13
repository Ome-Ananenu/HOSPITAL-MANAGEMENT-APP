package com.ome.springbootcrudoperation.service;
import java.util.Collection;
import java.util.Optional;

import com.ome.springbootcrudoperation.entity.Patient;


public interface PatientService {
    Patient createPatient(Patient patient);

    Collection<Patient> getPatients();

    Optional<Patient> getPatient(String id);

    Patient updatePatient(String id, Patient patient);

   String deletePatient(String id);
}
