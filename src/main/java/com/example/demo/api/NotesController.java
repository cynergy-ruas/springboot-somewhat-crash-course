package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Note;
import com.example.demo.services.NotesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// `@RequestMapping` is used to specify the REST endpoint URL.
@RequestMapping("api/v1/notes")

// `@RestController` is used to specify that this class is a web controller
// which has methods to execute when a REST endpoint is hit. It also tells 
// springboot that the value returned by the function should be passed into
// the response body.
@RestController
public class NotesController {
    NotesService service;

    // `@AutoWired` tells springboot that the `NotesService` object should
    // be taken from the IOC container (which manages the creation and management
    // of spring beans)
    @Autowired
    NotesController(NotesService service) {
        this.service = service;
    }

    /**
     * Endpoint to add a note. This function is called when 
     * a post request is made to api/v1/notes.
     * 
     * The request body (JSON) is converted to a `Note` Object
     * by spring boot by looking at the `@JsonProperty` annotations
     * made in the Note class.
     * 
     * @param note The note to add. Obtained from request body.
     */
    @PostMapping
    void addNote(@RequestBody Note note) {
        this.service.addNote(note);
    }

    /**
     * End point to get all notes in the database. This function is called
     * when a get request is made to api/v1/notes. The java List returned by
     * the function is coverted into a JSON object by Springboot using some 
     * inbuild springboot stuff (to convert the list) and the Note class
     * (to covert the Note objects)
     * 
     * @return a list of all the notes in the database
     */
    @GetMapping
    List<Note> getAllNotes() {
        return this.service.getAllNotes();
    }

    /**
     * Endpoint to get a single Note given the ID of that note.
     * 
     * @param id The id of the note to obtain
     * @return The Note object. Converted into a JSON object by springboot using the
     * `@JsonProperty` annotations in the Note class.
     */
    @GetMapping(params = {"note_id"})
    Note getNoteById(@RequestParam("note_id") UUID id) {
        return this.service.getNoteById(id);
    }
}
