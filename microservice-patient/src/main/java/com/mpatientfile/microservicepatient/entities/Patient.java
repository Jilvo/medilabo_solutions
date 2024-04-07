package com.mpatientfile.microservicepatient.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity()
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonIgnore
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "first_name", columnDefinition = "first_name")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "last_name")
    private String lastName;

    @Column(name = "birth_date", columnDefinition = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String phone, String address, LocalDate birthDate,
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Ignorer lors de la sérialisation
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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
