package com.example.API.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/

    private Integer id;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String gender;


    public Patient() {
    }

    public Patient(Integer id, String firstName, String lastName, String birthdate, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
