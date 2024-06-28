package com.microservicerapport.microservicerapport.models;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Patient {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String phone;

    private String gender;

    private String address;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String phone, String address, String birthDate,
                   String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(this.birthDate, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static Patient fromDict(String jsonString) {
        return JsonIterator.deserialize(jsonString, Patient.class);
    }

    public static String toDict(Patient patient) {
        return JsonStream.serialize(patient);
    }

}