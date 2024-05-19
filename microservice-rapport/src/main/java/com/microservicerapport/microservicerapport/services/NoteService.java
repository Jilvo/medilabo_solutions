package com.microservicerapport.microservicerapport.services;

import com.microservicerapport.microservicerapport.models.Note;
import com.microservicerapport.microservicerapport.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class NoteService {
    public List<Note> getNoteOfPatient(String id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
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
