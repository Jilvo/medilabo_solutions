package com.mpatientfile.microservicepatient.services;

import com.mpatientfile.microservicepatient.entities.Patient;
import com.mpatientfile.microservicepatient.repositories.PatientRepository;
import com.mpatientfile.microservicepatient.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePatient() {
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setPhone("1234567890");

        patientService.savePatient(patient);

        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    public void testUpdateExistingPatient() {
        Patient existingPatient = new Patient();
        existingPatient.setId(1L);
        existingPatient.setFirstName("John");
        existingPatient.setLastName("Doe");
        existingPatient.setPhone("1234567890");

        Patient updatedDetails = new Patient();
        updatedDetails.setFirstName("Jane");
        updatedDetails.setLastName("Doe");
        updatedDetails.setPhone("0987654321");

        when(patientRepository.save(any(Patient.class))).thenReturn(updatedDetails);

        Patient updatedPatient = patientService.updateExistingPatient(existingPatient, updatedDetails);

        assertEquals(updatedDetails.getFirstName(), updatedPatient.getFirstName());
        assertEquals(updatedDetails.getLastName(), updatedPatient.getLastName());
        assertEquals(updatedDetails.getPhone(), updatedPatient.getPhone());

        verify(patientRepository, times(1)).save(existingPatient);
    }
}