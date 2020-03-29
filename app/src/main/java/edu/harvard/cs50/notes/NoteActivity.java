package edu.harvard.cs50.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static edu.harvard.cs50.notes.MainActivity.database;

public class NoteActivity extends AppCompatActivity {
    private EditText editText;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        intent = getIntent();
        editText = findViewById(R.id.note_edit_text);
        editText.setText(intent.getStringExtra("content"));
    }

    @Override
    protected void onPause() {
        super.onPause();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        database.noteDao().save(editText.getText().toString(), id);
    }

    public void deleteNote(View view)
    {
        database.noteDao().delete(intent.getIntExtra("id", 0));
        finish();
    }
}
