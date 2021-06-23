package com.example.task2_3_note.view;

import com.example.task2_3_note.notes.Note;

public interface INewNote {
    String getHeader();
    String getBody();
    void returnNote(Note note);
}
