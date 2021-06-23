package com.example.task2_3_note.presenter;

import com.example.task2_3_note.model.Model;
import com.example.task2_3_note.notes.Note;
import com.example.task2_3_note.view.IMainIView;

public class MainPresenter {

    private IMainIView view;
    private final Model model;

    public MainPresenter() {
        this.model = new Model();
    }

    public void attachView(IMainIView view){
        this.view = view;
    }

    public void AddNote(Note note){
        model.addNote(note);
        view.refreshNotes(model.getLastNote());
    }

    public void openNote(int id){
        view.openNote(model.getNoteByID(id).getBody());
    }

}

