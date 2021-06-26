package com.example.task2_3_note.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.task2_3_note.R;
import com.example.task2_3_note.model.Note.Note;
import com.example.task2_3_note.model.Note.NotesAdapter;
import com.example.task2_3_note.presenter.MainPresenter;
import com.example.task2_3_note.view.interfaces.IMainIView;

public class ActivityMain extends AppCompatActivity implements IMainIView, NotesAdapter.OnNoteListener {

    private MainPresenter presenter;
    private NotesAdapter notesAdapter;

    public static final int GET_NOTE = 1;
    public static final String NOTE_CONTENT = "NOTE_CONTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainMenu) {
            //Явный интент
            Intent intent = new Intent(this, ActivityAbout.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    private void init() {
        findViewById(R.id.addNoteButton).setOnClickListener(v -> {
            //Неявный интент
            Intent intent = new Intent("android.intent.action.ACTION_ADD_NOTE");
            startActivityForResult(intent, GET_NOTE);
        });
        presenter = new MainPresenter(this);

        RecyclerInit();
    }

    private void RecyclerInit() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(this);
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void refreshNotes(Note note) {
        notesAdapter.addItem(note);
    }

    @Override
    public void openNote(String content) {
        Intent openNote = new Intent(this, ActivityNoteContent.class);
        openNote.putExtra(NOTE_CONTENT, content);
        startActivity(openNote);
    }

    @Override
    public void onNoteClick(int position) {
        presenter.openNote(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}
