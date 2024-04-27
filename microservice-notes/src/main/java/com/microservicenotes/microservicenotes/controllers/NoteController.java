package com.microservicenotes.microservicenotes.controllers;

import com.microservicenotes.microservicenotes.repositories.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicenotes.microservicenotes.entities.Note;
import com.microservicenotes.microservicenotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;

    @PostMapping
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> get(@PathVariable String id) {
        Optional<Note> patient = noteRepository.findById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok().body(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Note noteDetailsData) {
        Optional<Note> patient = noteRepository.findById(id);
        if (patient.isPresent()) {
            Note toUpdatePatient = patient.get();
            Note updatedPatient = noteService.updateExistingNote(toUpdatePatient, noteDetailsData);
            return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable String id) {
        Optional<Note> patient = noteRepository.findById(id);
        if (patient.isPresent()) {
            noteRepository.delete(patient.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
    }
}
