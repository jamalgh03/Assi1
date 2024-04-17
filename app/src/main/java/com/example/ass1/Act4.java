package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ass1.Note;
import com.example.ass1.R;

import java.util.ArrayList;

public class Act4 extends AppCompatActivity {
    private EditText txt1;
    private EditText txt2;
    private Button add; //
    private RadioGroup rdGroup;
    private RadioButton done, not;
    private ListView list;
    private ArrayList<Note> notesList;
    private ArrayAdapter<Note> adapter;
    private SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);

        txt1 = findViewById(R.id.txt11);
        txt2 = findViewById(R.id.txt22);
        add = findViewById(R.id.add);
        rdGroup = findViewById(R.id.rdGroup);
        done = findViewById(R.id.done); // Done radio button
        not = findViewById(R.id.not); // Not yet radio button
        list = findViewById(R.id.list);

        sharedPreferences = getSharedPreferences("notes", Context.MODE_PRIVATE);

        notesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        list.setAdapter(adapter);

        // Load notes from SharedPreferences when activity starts
        loadNotes();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = txt1.getText().toString();
                String date = txt2.getText().toString();
                String state = "";

                int selectedId = rdGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.done) {
                    state = "Done";
                } else if (selectedId == R.id.not) {
                    state = "Not yet";
                }

                Note note = new Note(task, date, state);
                notesList.add(note);
                adapter.notifyDataSetChanged();

                // Save notes to SharedPreferences
                saveNotes();

                // Clear input fields after adding note
                txt1.setText("");
                txt2.setText("");
                rdGroup.clearCheck();
            }
        });
    }

    // Method to save notes to SharedPreferences
    private void saveNotes() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("size", notesList.size());
        for (int i = 0; i < notesList.size(); i++) {
            editor.putString("task" + i, notesList.get(i).getTask());
            editor.putString("date" + i, notesList.get(i).getDate());
            editor.putString("state" + i, notesList.get(i).getState());
        }
        editor.apply();
    }

    // Method to load notes from SharedPreferences
    private void loadNotes() {
        int size = sharedPreferences.getInt("size", 0);
        for (int i = 0; i < size; i++) {
            String task = sharedPreferences.getString("task" + i, "");
            String date = sharedPreferences.getString("date" + i, "");
            String state = sharedPreferences.getString("state" + i, "");
            Note note = new Note(task, date, state);
            notesList.add(note);
        }
        adapter.notifyDataSetChanged();
    }
}
