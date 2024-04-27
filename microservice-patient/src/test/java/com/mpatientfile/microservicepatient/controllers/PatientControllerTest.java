package com.mpatientfile.microservicepatient.controllers;

import com.mpatientfile.microservicepatient.entities.Patient;
import com.mpatientfile.microservicepatient.repositories.PatientRepository;
import com.mpatientfile.microservicepatient.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientControllerTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
    }


    @Test
    public void testGetAllPatients() {
        Patient patient1 = new Patient();
        patient1.setId(1L);
        Patient patient2 = new Patient();
        patient2.setId(2L);
        List<Patient> patients = Arrays.asList(patient1, patient2);
        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> response = patientController.getAllPatients();

        assertEquals(patients.size(), response.size());
        assertEquals(patients.get(0), response.get(0));
        assertEquals(patients.get(1), response.get(1));
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    public void testGetPatientById() {
        Patient patient = new Patient();
        patient.setId(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        ResponseEntity<Patient> response = patientController.getPatientById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patient, response.getBody());
        verify(patientRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdatePatient() {
        Patient existingPatient = new Patient();
        existingPatient.setId(1L);
        Patient updatedPatient = new Patient();
        updatedPatient.setId(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(existingPatient));
        when(patientService.updateExistingPatient(any(Patient.class), any(Patient.class))).thenReturn(updatedPatient);

        ResponseEntity<String> response = patientController.updatePatient(1L, new Patient());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated successfully", response.getBody());
        verify(patientRepository, times(1)).findById(1L);
        verify(patientService, times(1)).updateExistingPatient(any(Patient.class), any(Patient.class));
    }

    // Test similar to testGetPatientById for the case where patient is not found

    @Test
    public void testDeletePatient() {
        Patient patient = new Patient();
        patient.setId(1L);
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        ResponseEntity<String> response = patientController.deletePatient(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(patientRepository, times(1)).findById(1L);
        verify(patientRepository, times(1)).delete(patient);
    }

    // Test similar to testGetPatientById for the case where patient is not found
}
