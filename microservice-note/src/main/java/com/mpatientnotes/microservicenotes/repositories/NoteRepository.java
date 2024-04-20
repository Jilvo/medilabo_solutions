package com.mpatientnotes.microservicenotes.repositories;

import com.mpatientnotes.microservicenotes.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}