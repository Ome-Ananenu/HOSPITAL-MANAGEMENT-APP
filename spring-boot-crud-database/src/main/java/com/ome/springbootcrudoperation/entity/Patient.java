package com.ome.springbootcrudoperation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Patient {

    @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String dateOfBirth;

    @Column
    private int phoneNumber;

    @Column
    private String occupation;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString(){
        return "Patient [id=" + id + ", firstname" + firstName +" ]"+" dateOfBirth "+ dateOfBirth;
    }
}
