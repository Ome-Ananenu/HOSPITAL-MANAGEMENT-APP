package com.ome.springbootcrudoperation.service;

import com.ome.springbootcrudoperation.entity.Doctor;

import java.util.Collection;
import java.util.Optional;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);

    Collection<Doctor> getDoctors();

    Optional<Doctor> getDoctor(String id);

    Doctor updateDoctor(String id, Doctor doctor);

    String deleteDoctor(String id);
}
