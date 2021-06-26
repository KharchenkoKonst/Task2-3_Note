package com.example.task2_3_note.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.task2_3_note.R;

import java.util.Objects;

public class ActivityNoteContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_content);
        Objects.requireNonNull(getSupportActionBar()).hide();

        String content = getIntent().getExtras().getString(ActivityMain.NOTE_CONTENT);
        ((TextView) findViewById(R.id.noteContent)).setText(content);
    }
}