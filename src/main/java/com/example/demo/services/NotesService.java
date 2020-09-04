package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import com.example.demo.dao.NotesDao;
import com.example.demo.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * the `@Service` annotations tells springboot that this class 
 * is a spring bean, "an operation offered as an interface that stands 
 * alone in the model, with no encapsulated state.". basically the core 
 * business logic goes here.
 */
@Service
public class NotesService {
    NotesDao dao;

    // `@AutoWired` tells springboot that the `NotesDao` object should
    // be taken from the IOC container (which manages the creation and management
    // of spring beans)
    // and the `@Qualifier` annotation tells springboot which NotesDao object
    // is needed, given the tag.
    @Autowired
    NotesService(@Qualifier("fake") NotesDao dao) {
        this.dao = dao;
    }

    /**
     * Adds a note.
     * @param note The note
     * @return the status code of the operation
     */
    public int addNote(Note note) {
        // generating the random id of the note
        UUID id = UUID.randomUUID();

        // calling the function which adds the note to the database and 
        // returning the status code of that operation
        return this.dao.addNote(new Note(id, note.getTitle(), note.getBody()));
    }

    /**
     * Gets all notes in the database.
     * @return a list of all the notes in the database.
     */
    public List<Note> getAllNotes() {
        return this.dao.getAllNotes();
    }

    /**
     * Gets the note given the id of said note.
     * @param id the id of the note to get.
     * @return The note.
     */
    public Note getNoteById(UUID id) {
        return this.dao.getNoteById(id);
    }
}
