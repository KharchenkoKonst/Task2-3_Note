package com.example.task2_3_note.presenter;

import com.example.task2_3_note.model.Note.Note;
import com.example.task2_3_note.view.interfaces.INewNote;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
В случае работы с БД или локальной файловой системой мы могли бы использовать модель для сохранения
введённых пользователем данных. В данном случае модель не используется - пользовательские данные
возвращаются вызвавшей активити.
*/

public class NewNotePresenter {

    private final INewNote view;


    public NewNotePresenter(INewNote view) {
        this.view = view;
    }

    public void createNote() {
        String header = view.getHeader();
        String body = view.getBody();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String date = dateFormat.format(new Date());
        Note note = new Note(header, body, date);
        view.returnNote(note);
    }
}
