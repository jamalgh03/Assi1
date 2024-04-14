package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button note; // note button
    private Button enter; // enter button
    private TextView view; // note show text view

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView1); // image
        imageView.setImageResource(R.drawable.ass_photo);

        note = findViewById(R.id.note);
        view = findViewById(R.id.view);
        enter = findViewById(R.id.Enter);

        note.setOnClickListener(new View.OnClickListener() { // note action
            @Override
            public void onClick(View v) {
                if (view.getVisibility() == View.GONE) { // if gone ?
                    view.setVisibility(View.VISIBLE); // yes ? => visible
                } else {
                    view.setVisibility(View.GONE); // no ? => gone
                }
            }
        });

        enter.setOnClickListener(new View.OnClickListener() { // next activity action
            @Override
            public void onClick(View v) {
                secondAct();
            }
        });
    }

    public void secondAct() { // con activity
        Intent intent = new Intent(this, act2.class);
        startActivity(intent); // call back method
    }
}
