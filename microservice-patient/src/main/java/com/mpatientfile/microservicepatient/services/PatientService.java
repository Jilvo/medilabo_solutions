package com.mpatientfile.microservicepatient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpatientfile.microservicepatient.entities.Patient;
import com.mpatientfile.microservicepatient.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    public PatientRepository patientRepository;

    public void savePatient(Patient patient) {
        // TODO add logs
        try {
            System.out.println("save patient");
            patientRepository.save(patient);

        } catch (Exception e) {
            System.out.println("problem occurred with saving patient " + e);
        }
    }
}
