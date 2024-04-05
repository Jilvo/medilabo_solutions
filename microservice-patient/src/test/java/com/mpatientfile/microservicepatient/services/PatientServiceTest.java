package com.mpatientfile.microservicepatient.services;

import com.mpatientfile.microservicepatient.entities.Patient;
import com.mpatientfile.microservicepatient.repositories.PatientRepository;
import com.mpatientfile.microservicepatient.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @InjectMocks
    PatientService patientService;

    @Mock
    PatientRepository patientRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePatient() {
        Patient patient = new Patient();
        patientService.savePatient(patient);
        verify(patientRepository, times(1)).save(patient);
    }
}