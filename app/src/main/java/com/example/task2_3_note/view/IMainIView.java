package com.example.task2_3_note.view;

import com.example.task2_3_note.notes.Note;

public interface IMainIView {
    void refreshNotes(Note note);

    void openNote(String content);
}
