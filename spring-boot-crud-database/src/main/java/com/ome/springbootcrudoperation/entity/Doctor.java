package com.ome.springbootcrudoperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Doctor {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    @NotEmpty(message = "First name is required.")
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String specialty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String department) {
        this.specialty = department;
    }

    @Override
    public String toString(){
        return "Patient [id=" + id + ", firstname" + firstName +" ]"+" specialty "+ specialty;
    }
}
