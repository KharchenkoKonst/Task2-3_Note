package com.example.task2_3_note.model.Note;

import java.io.Serializable;

public class Note implements Serializable {
    private final String header;
    private final String body;
    private final String date;

    public Note(String header, String body, String date) {
        this.header = header;
        this.body = body;
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }
}
