package com.microservicerapport.microservicerapport.models;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import com.jsoniter.spi.TypeLiteral;

import java.util.List;

public class Note {

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

    public static Note fromDict(String jsonString) {
        return JsonIterator.deserialize(jsonString, Note.class);
    }

    public static List<Note> fromDictofList(String jsonString) {
        return JsonIterator.deserialize(jsonString, new TypeLiteral<List<Note>>(){});
    }
    public static String toDict(Note note) {
        return JsonStream.serialize(note);
    }
}