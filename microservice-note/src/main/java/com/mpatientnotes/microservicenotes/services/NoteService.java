package com.mpatientnotes.microservicenotes.services;


import com.mpatientnotes.microservicenotes.entities.Note;
import com.mpatientnotes.microservicenotes.repositories.NoteRepository;
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

    public void delete(String id) {
        noteRepository.deleteById(id);
    }
}