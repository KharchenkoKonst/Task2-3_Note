package com.example.task2_3_note.presenter;

import com.example.task2_3_note.model.Model;
import com.example.task2_3_note.notes.Note;
import com.example.task2_3_note.view.IMainIView;


//Можно ли вынести общий функционал в AbstractPresenter?
public class MainPresenter {

    private IMainIView view;
    private final Model model;

    public MainPresenter(IMainIView view) {
        this.model = new Model();
        this.view = view;
    }

    public void AddNote(Note note) {
        model.addNote(note);
        view.refreshNotes(model.getNote());
    }

    public void openNote(int id) {
        view.openNote(model.getNote(id).getBody());
    }

}

