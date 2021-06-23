package com.example.task2_3_note.presenter;

import com.example.task2_3_note.notes.Note;
import com.example.task2_3_note.view.INewNote;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
В случае работы с БД или локальной файловой системой мы могли бы использовать модель для сохранения
введённых пользователем данных. В данном случае модель не используется - пользовательские данные
возвращаются вызвавшей активити.
*/

public class NewNotePresenter {

    private INewNote view;

    public void attachView(INewNote view) {
        this.view = view;
    }

    public void createNote() {
        String header = view.getHeader();
        String body = view.getBody();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        String date = dateFormat.format(new Date());
        Note note = new Note(header, body, date);
        view.returnNote(note);
    }
}
