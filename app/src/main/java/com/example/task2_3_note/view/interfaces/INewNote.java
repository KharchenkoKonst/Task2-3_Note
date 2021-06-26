package com.example.task2_3_note.view.interfaces;

import com.example.task2_3_note.model.Note.Note;

public interface INewNote {
    String getHeader();
    String getBody();
    void returnNote(Note note);
}
