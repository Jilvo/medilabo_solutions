package com.mpatientnotes.microservicenotes.controllers;

import com.mpatientnotes.microservicenotes.entities.Note;
import com.mpatientnotes.microservicenotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @GetMapping("/{id}")
    public Note get(@PathVariable String id) {
        return noteService.get(id);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAll();
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable String id, @RequestBody Note note) {
        return noteService.update(id, note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        noteService.delete(id);
    }
}