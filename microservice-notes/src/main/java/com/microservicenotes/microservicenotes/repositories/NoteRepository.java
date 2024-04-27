package com.microservicenotes.microservicenotes.repositories;

import com.microservicenotes.microservicenotes.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByPatId(String patId);

}