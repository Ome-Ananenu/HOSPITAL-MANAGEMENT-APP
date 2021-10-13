package com.ome.springbootcrudoperation.controller;

import java.util.Collection;
import javax.validation.Valid;

import com.ome.springbootcrudoperation.entity.Doctor;
import com.ome.springbootcrudoperation.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {


    @Autowired
    DoctorService doctorService;

    //Add Doctors
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.OK);
    }

    //Get all Doctors
    @GetMapping
    public ResponseEntity<Collection<Doctor>> getDoctors() {
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

    //Get one Doctor by id
    @GetMapping(path="/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable String id) {
        return new ResponseEntity(doctorService.getDoctor(id), HttpStatus.OK);
    }

    //Update a Doctor
    @PutMapping(path="/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctor), HttpStatus.OK);
    }

    //Delete a Doctor
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
