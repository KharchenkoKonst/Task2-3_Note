package com.example.task2_3_note.view.interfaces;

import com.example.task2_3_note.model.Note.Note;

public interface IMainIView {
    void refreshNotes(Note note);

    void openNote(String content);
}
