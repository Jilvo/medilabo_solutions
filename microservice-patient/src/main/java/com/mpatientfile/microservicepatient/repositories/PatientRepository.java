package com.mpatientfile.microservicepatient.repositories;

import com.mpatientfile.microservicepatient.entities.Patient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findById(Long id);
}
