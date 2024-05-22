package com.microservicerapport.microservicerapport.services;

import com.microservicerapport.microservicerapport.models.Patient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PatientService {
    /**
     * Represents a patient.
     */
    public Patient getPatient(String id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://patient-service:9000/patients/" + id))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Patient patient = Patient.fromDict(response.body());
            return patient;
        } catch (IOException | InterruptedException | URISyntaxException e) {
            return null;
        }

    }
}
