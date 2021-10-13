package com.ome.springbootcrudoperation.controller;
import java.util.Collection;
import javax.validation.Valid;
import com.ome.springbootcrudoperation.entity.Patient;
import com.ome.springbootcrudoperation.model.PatientDto;
import com.ome.springbootcrudoperation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    //Add Patients
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    //Get all Patients
    @GetMapping
    public ResponseEntity<Collection<Patient>> getPatients() {
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    }

   //Get one patient by id
   @GetMapping(path="/{id}")
   public ResponseEntity<Patient> getPatient(@PathVariable String id) {
       return new ResponseEntity(patientService.getPatient(id), HttpStatus.OK);
   }

   //Update a patient
    @PutMapping(path="/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    //Delete a patient
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
