package com.mpatientfile.microservicepatient.entities;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import jakarta.persistence.*;

import java.util.Date;

@Entity()
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", columnDefinition = "first_name")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "last_name")
    private String lastName;
    @Column(name = "birth_date", columnDefinition = "birth_date")
    private Date birthDate;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code", columnDefinition = "zip_code")
    private String zipCode;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "last_update", columnDefinition = "last_update")
    private Date lastUpdate;
    @Column(name = "created_date", columnDefinition = "created_date")
    private Date createdDate;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String email, String phone, String address, String city,
            String state, String zipCode, String country, Date birthDate, Date lastUpdate, Date createdDate,
            String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.gender = gender;
        this.birthDate = birthDate;
        this.lastUpdate = lastUpdate;
        this.createdDate = createdDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public static Patient fromDict(String jsonString) {
        return JsonIterator.deserialize(jsonString, Patient.class);
    }

    public static String toDict(Patient patient) {
        return JsonStream.serialize(patient);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
    }

}
