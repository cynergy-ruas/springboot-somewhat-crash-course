package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Note;

import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PostgresDB implements NotesDao {

    @Override
    public int addNote(Note note) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Note> getAllNotes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Note getNoteById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
