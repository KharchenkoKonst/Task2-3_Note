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

/*
    Делал сразу 2 задания в одном проекте, не очень хочется разбивать. Далее будет указано, какие
части к какому из заданий относятся.
    PS Кажется я тогда плохо прочитал задание и не заметил слова "фрагмент".... Переделывать не буду,
в последующих работах использую и транзакции и navigation component.

    Task 2
- Сделать вторую активити (например, About) и ее открытие из первой.
- Сделать неявный интент (например, отправку текста заметки во внешнее приложение)

    Task 3
- Сделать в активити фрагмент с RecyclerView.
- Отобразить в RecyclerView список наименований заметок
- Создать второй фрагмент для отображения информации о заметке(наименование заметки, текст заметки и к примеру дата заметки)
- Реализовать показ деталей заметки на втором фрагменте при нажатии на пункт RecyclerView
 */

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

    /**
     * Запуск явного интента для отображения содержимого about
     * @param item MenuItem - единственная кнопка about
     * @return false to allow normal menu processing
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.aboutMenu) {
            //Явный интент
            Intent intent = new Intent(this, ActivityAbout.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    /*
    Task 3
    Запуск неявного интента (своего) для открытия активити добавления новой заметки.
    Данные новой заметки будут возвращены через onActivityResult и перенаправлены в presenter для
    добавления в БД.
    PS возможно слишком замудрено, но проект учебный поэтому так.
     */
    private void init() {
        findViewById(R.id.addNoteButton).setOnClickListener(v -> {
            //Неявный интент
            Intent intent = new Intent("android.intent.action.ACTION_ADD_NOTE");
            startActivityForResult(intent, GET_NOTE);
        });
        presenter = new MainPresenter(this);
        RecyclerInit();
    }

    //Task 3
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

    //Task 3
    /**
     * Используется презентером для рефреша RecyclerView в случае успешного добавления заметки в БД
     * @param note объект заметки, которую необходимо добавить в ресайклер
     */
    @Override
    public void refreshNotes(Note note) {
        notesAdapter.addItem(note);
    }

    //Task 3
    /*
     Использования презентера для открытия заметки, считаю, было лишним. На тот момент я
     руководствовался тем, что при нажатии на элемент ресайклера будет получен только его id и необходим
     поиск по id в БД.
     */
    @Override
    public void openNote(String content) {
        Intent openNote = new Intent(this, ActivityNoteContent.class);
        openNote.putExtra(NOTE_CONTENT, content);
        startActivity(openNote);
    }

    //Task 3
    @Override
    public void onNoteClick(int position) {
        presenter.openNote(position);
    }

    /* А это обязательно делать? JVM вроде сама следит за сборкой мусора, а следить за подобными вещами
    самому несколько трудоёмко.
    */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }
}
