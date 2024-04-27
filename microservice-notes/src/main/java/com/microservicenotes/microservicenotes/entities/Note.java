package com.microservicenotes.microservicenotes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {

    @Id
    private String id;
    private String patId;
    private String patient;
    private String note;

    public Note() {
    }

    public Note(String id, String patId, String patient, String note) {
        this.id = id;
        this.patId = patId;
        this.patient = patient;
        this.note = note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPatId() {
        return this.patId;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getPatient() {
        return this.patient;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return this.note;
    }
}