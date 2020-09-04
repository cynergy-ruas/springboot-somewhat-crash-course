package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {
    UUID id;
    String title;
    String body;

    // `@JsonProperty("id")` is used to tell springboot that the value of the 'id' key
    // in the JSON object should be passed to the `id` argument in the constructor. Also it 
    // is used in the reverse way - Java object to JSON.
    // Similarily for the other parameters
    public Note(@JsonProperty("id") UUID id, @JsonProperty("title") String title, @JsonProperty("body") String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
