package com.ome.springbootcrudoperation.repo;

import com.ome.springbootcrudoperation.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, String> {
}
