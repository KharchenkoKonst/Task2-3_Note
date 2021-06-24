package com.example.task2_3_note.presenter;

import com.example.task2_3_note.model.Model;
import com.example.task2_3_note.notes.Note;
import com.example.task2_3_note.view.IMainIView;

import java.util.List;


//Можно ли вынести общий функционал в AbstractPresenter?
public class MainPresenter {

    private final IMainIView view;
    private final Model model;

    public MainPresenter(IMainIView view) {
        this.model = new Model();
        this.view = view;
    }

    public void AddNote(Note note) {
        List<Note> notes = model.getNotes();
        notes.add(note);
        model.setNotes(notes);
        view.refreshNotes(note);
    }

    public void openNote(int id) {
        view.openNote(model.getNotes().get(id).getBody());
    }

}

