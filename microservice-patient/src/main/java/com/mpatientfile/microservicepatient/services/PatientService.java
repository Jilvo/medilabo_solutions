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
        /**
         * Saves a patient to the repository.
         *
         * @param patient The patient to save.
         */
        try {
            System.out.println("save patient");
            patientRepository.save(patient);

        } catch (Exception e) {
            System.out.println("problem occurred with saving patient " + e);
        }
    }

    public Patient updateExistingPatient(Patient patient, Patient patientDetailsData) {
        /**
         * Updates an existing patient with new details.
         *
         * @param patient            The existing patient to update.
         * @param patientDetailsData The new details to update the patient with.
         * @return The updated patient, or null if an error occurred.
         */
        try {
            System.out.println("update patient");
            patient.setFirstName(patientDetailsData.getFirstName());
            patient.setLastName(patientDetailsData.getLastName());
            patient.setPhone(patientDetailsData.getPhone());
            patient.setAddress(patientDetailsData.getAddress());
            patient.setBirthDate(patientDetailsData.getBirthDate());
            patient.setGender(patientDetailsData.getGender());
            savePatient(patient);
            return patient;

        } catch (Exception e) {
            System.out.println("problem occurred with updating patient " + e);
            return null;
        }
    }

}
