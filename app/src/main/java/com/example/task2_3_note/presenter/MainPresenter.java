package com.example.task2_3_note.presenter;

import android.content.Intent;

import com.example.task2_3_note.model.Model;
import com.example.task2_3_note.model.Note.Note;
import com.example.task2_3_note.view.ActivityMain;
import com.example.task2_3_note.view.interfaces.IMainIView;

import java.util.List;


public class MainPresenter {

    private final IMainIView view;
    private final Model model;

    public MainPresenter(IMainIView view) {
        this.model = new Model();
        this.view = view;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == ActivityMain.RESULT_OK) {
            if (requestCode == ActivityMain.GET_NOTE) {
                Note note = (Note) data.getExtras().getSerializable(Note.class.getSimpleName());
                AddNote(note);
            }
        }
    }

    private void AddNote(Note note) {
        List<Note> notes = model.getNotes();
        notes.add(note);
        model.setNotes(notes);
        view.refreshNotes(note);
    }

    public void openNote(int id) {
        view.openNote(model.getNotes().get(id).getBody());
    }

}

