package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Note;

import org.springframework.stereotype.Repository;

/**
 * `@Repository` tells springboot that this class is a bean, which
 * is "a mechanism for encapsulating storage, retrieval, and search 
 * behavior which emulates a collection of objects". basically talks to db.
 * 
 * The "fake" passed as argument is like a tag that is used by the 
 * `@Qualifier` annotation
 */
@Repository("fake")
public class FakeDB implements NotesDao {

    List<Note> database;

    FakeDB() {
        this.database = new ArrayList<Note>();
    }

    @Override
    public int addNote(Note note) {
        this.database.add(note);

        return 0;
    }

    @Override
    public List<Note> getAllNotes() {
        return this.database;
    }

    @Override
    public Note getNoteById(UUID id) {

        // for every note in the database
        for (Note note: database) {
            // if the id of the note is equal to the 
            // given id
            if (note.getId().equals(id))
                // return the note
                return note;
        }

        // else return null
        return null;
    }
    
}
