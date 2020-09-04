package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Note;

/**
 * Interface defining the methods that a subclass has to be implemented
 */
public interface NotesDao {

    /**
     * Adds a note to the database.
     * @param note the note to add.
     * @return status code of the operation
     */
    public int addNote(Note note);

    /**
     * Gets all the notes of a user.
     * @return The list of all the notes in the database.
     */
    public List<Note> getAllNotes();

    /**
     * Gets a note given the ID of the note.
     * @param id the id of the note that is required
     * @return The note.
     */
    public Note getNoteById(UUID id);
}