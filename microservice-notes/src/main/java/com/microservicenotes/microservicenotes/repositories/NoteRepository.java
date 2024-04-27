package com.microservicenotes.microservicenotes.repositories;

import com.microservicenotes.microservicenotes.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}