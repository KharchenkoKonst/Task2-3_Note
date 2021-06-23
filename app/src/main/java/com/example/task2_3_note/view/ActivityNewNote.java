package com.example.task2_3_note.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.task2_3_note.R;
import com.example.task2_3_note.notes.Note;
import com.example.task2_3_note.presenter.NewNotePresenter;

public class ActivityNewNote extends AppCompatActivity implements INewNote {

    private NewNotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        init();
    }

    private void init() {
        findViewById(R.id.saveNoteButton).setOnClickListener(v -> {
            presenter.createNote();
        });
        presenter = new NewNotePresenter();
        presenter.attachView(this);
    }

    @Override
    public String getHeader() {
        return ((EditText) findViewById(R.id.noteHeader)).getText().toString();
    }

    @Override
    public String getBody() {
        return ((EditText) findViewById(R.id.noteBody)).getText().toString();
    }

    @Override
    public void returnNote(Note note) {
        Intent newNote = new Intent();
        newNote.putExtra(Note.class.getSimpleName(), note);
        setResult(RESULT_OK, newNote);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}