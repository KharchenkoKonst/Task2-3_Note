package com.example.task2_3_note.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.task2_3_note.R;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
    }
}