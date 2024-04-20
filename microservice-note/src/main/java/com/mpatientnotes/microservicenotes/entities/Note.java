package com.mpatientnotes.microservicenotes.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {

    @Id
    private String id;
    private String title;
    private String content;

    public void setId(String id) {
    }

    // Getters and Setters
}