package com.example.task2_3_note.view.interfaces;

import android.os.Bundle;

import com.example.task2_3_note.model.Note.Note;

public interface IMainView {
    void refreshNotes(Note note);

    void openNote(Bundle bundle);
}
