package com.microservicerapport.microservicerapport.services;

import com.microservicerapport.microservicerapport.models.Note;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class NoteService {
    /**
     * Retrieves the notes of a patient based on the provided ID.
     *
     * @param id The ID of the patient.
     * @return A list of Note objects representing the notes of the patient.
     *         Returns null if an error occurs during the retrieval process.
     */
    public List<Note> getNoteOfPatient(String id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    // .uri(new URI("http://localhost:9001/notes/patId/" + id))
                    .uri(new URI("http://note-service:9001/notes/patId/" + id))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            List<Note> notes = Note.fromDictofList(response.body());
            return notes;
        } catch (Exception e) {
            return null;
        }
    }
}
