package com.example.task2_3_note.model;

import com.example.task2_3_note.notes.Note;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Note> notes;

    public Model() {
        notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
