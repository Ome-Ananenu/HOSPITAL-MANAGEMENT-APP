package com.ome.springbootcrudoperation.repo;

import com.ome.springbootcrudoperation.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, String> {
}
