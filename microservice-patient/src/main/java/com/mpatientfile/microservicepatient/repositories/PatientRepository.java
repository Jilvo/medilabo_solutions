package com.mpatientfile.microservicepatient.repositories;

import com.mpatientfile.microservicepatient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findById(Long id);
}
