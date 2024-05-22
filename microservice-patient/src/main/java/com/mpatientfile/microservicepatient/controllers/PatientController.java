package com.mpatientfile.microservicepatient.controllers;

import com.mpatientfile.microservicepatient.repositories.PatientRepository;
import com.mpatientfile.microservicepatient.services.PatientService;
import com.mpatientfile.microservicepatient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    /**
     * Creates a new patient.
     *
     * @param patient the patient object to be created
     * @return the ResponseEntity with the created patient and HTTP status code
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        System.out.println(patient);
        patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    /**
     * Retrieves a list of all patients.
     *
     * @return A list of Patient objects representing all patients.
     */
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Retrieves a patient by their ID.
     *
     * @param id the ID of the patient to retrieve
     * @return the ResponseEntity containing the patient if found, or a 404 Not
     *         Found response if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok().body(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates a patient with the given ID.
     *
     * @param id                 the ID of the patient to update
     * @param patientDetailsData the updated patient details
     * @return a ResponseEntity with the status and message indicating the result of
     *         the update operation
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable(value = "id") Long id,
            @RequestBody Patient patientDetailsData) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            Patient toUpdatePatient = patient.get();
            Patient updatedPatient = patientService.updateExistingPatient(toUpdatePatient, patientDetailsData);
            return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }

    /**
     * Deletes a patient with the specified ID.
     *
     * @param id the ID of the patient to delete
     * @return a ResponseEntity with a success status if the patient is deleted, or
     *         a not found status if the patient is not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable(value = "id") Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.delete(patient.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }
}