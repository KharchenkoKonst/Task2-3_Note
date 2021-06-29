package com.example.task2_3_note.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task2_3_note.R;
import com.example.task2_3_note.view.ActivityMain;

import org.jetbrains.annotations.NotNull;

public class ContentFragment extends Fragment {
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        String body = getArguments().getString(ActivityMain.NOTE_CONTENT);
        View v = inflater.inflate(R.layout.fragment_body, null);
        ((TextView) v.findViewById(R.id.textView)).setText(body);
        return v;
    }
}
