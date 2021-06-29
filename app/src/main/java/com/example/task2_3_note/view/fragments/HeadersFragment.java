package com.example.task2_3_note.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2_3_note.R;
import com.example.task2_3_note.model.Note.Note;
import com.example.task2_3_note.model.Note.NotesAdapter;

import org.jetbrains.annotations.NotNull;

public class HeadersFragment extends Fragment implements NotesAdapter.OnNoteListener {

    public interface IClickListener {
        void newNoteClicked();

        void noteSelected(int position);
    }

    private IClickListener listener;
    private NotesAdapter notesAdapter;

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        listener = (IClickListener) context;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_headers, null);
        init(v);
        return v;
    }

    private void init(View v) {
        v.findViewById(R.id.addNoteButton).setOnClickListener(view -> listener.newNoteClicked());
        RecyclerInit(v);
    }

    private void RecyclerInit(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        notesAdapter = new NotesAdapter(this);
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    public void onNoteClick(int position) {
        listener.noteSelected(position);
    }

    public void addNote(Note note) {
        notesAdapter.addItem(note);
    }
}
