package com.example.task2_3_note.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.task2_3_note.R;
import com.example.task2_3_note.model.Note.Note;
import com.example.task2_3_note.model.Note.NotesAdapter;
import com.example.task2_3_note.presenter.MainPresenter;
import com.example.task2_3_note.view.fragments.ContentFragment;
import com.example.task2_3_note.view.fragments.HeadersFragment;
import com.example.task2_3_note.view.interfaces.IMainView;

public class ActivityMain extends AppCompatActivity implements
        IMainView, HeadersFragment.IClickListener {

    private MainPresenter presenter;
    private HeadersFragment headers;

    public static final int GET_NOTE = 1;
    public static final String NOTE_CONTENT = "NOTE_CONTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headers = new HeadersFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, headers);
        transaction.commit();
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
        presenter = new MainPresenter(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void refreshNotes(Note note) {
        HeadersFragment fragment = (HeadersFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        fragment.addNote(note);
    }

    @Override
    public void openNote(Bundle data) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment content = new ContentFragment();
        content.setArguments(data);
        ft.add(R.id.fragment_container, content);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    @Override
    public void newNoteClicked() {
        Intent intent = new Intent("android.intent.action.ACTION_ADD_NOTE");
        startActivityForResult(intent, ActivityMain.GET_NOTE);
    }

    /*Выбран пункт RecyclerView во фрагменте*/
    @Override
    public void noteSelected(int position) {
        presenter.openNote(position);
    }
}
