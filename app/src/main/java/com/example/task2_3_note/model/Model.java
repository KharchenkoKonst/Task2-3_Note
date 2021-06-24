package com.example.task2_3_note.model;

import com.example.task2_3_note.notes.Note;

import java.util.ArrayList;

public class Model {
    private ArrayList<Note> notes;

    public Model() {
        notes = new ArrayList<>();
    }

    public Note getNote(){
        return notes.get(notes.size() - 1);
    }
    public Note getNote(int id){
        return notes.get(id);
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}
