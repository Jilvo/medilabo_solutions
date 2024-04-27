package com.microservicenotes.microservicenotes.services;
import com.microservicenotes.microservicenotes.entities.Note;
import com.microservicenotes.microservicenotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Note get(String id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note update(String id, Note note) {
        note.setId(id);
        return noteRepository.save(note);
    }

    public Note updateExistingNote(Note existingNote, Note noteDetailsData) {
        existingNote.setPatId(noteDetailsData.getPatId());
        existingNote.setPatient(noteDetailsData.getPatient());
        existingNote.setNote(noteDetailsData.getNote());
        return noteRepository.save(existingNote);
    }

    public void delete(String id) {
        noteRepository.deleteById(id);
    }
}