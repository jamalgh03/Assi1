package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Act3 extends AppCompatActivity {
    private Spinner spn; //
    private Button enter; //
    private TextView result1;
    private Button Goo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        ImageView imageView = findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ass_photo);
        findview();
        Goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondAct();
            }
        });
        ChoiceSpn();


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer selectedNumber = (Integer) spn.getSelectedItem();
                String multiplicationTable = MultiTable(selectedNumber);
                result1.setText(multiplicationTable);
            }
        });
    }
    private void ChoiceSpn() { // Spinner Choice
        Integer[] cho = getChoice();
        ArrayAdapter<Integer> arr = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cho);
        spn.setAdapter(arr);
    }

    private Integer[] getChoice() {// 1 - 9 multi choice
        Integer[] mult = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // array
        return mult;
    }

    private String MultiTable(int number) {
        StringBuilder table = new StringBuilder();
        try {
            for (int i = 1; i <= 9; i++) {
                int result = number * i;
                table.append(number).append(" x ").append(i).append(" = ").append(result).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table.toString();
    }

    public void secondAct() {//2nd activity
        Intent intent = new Intent(this, Act4.class);
        startActivity(intent);
    }

    public void secondAct2() {//3th activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void findview() {
        spn = findViewById(R.id.spn);
        enter = findViewById(R.id.button5);
        result1 = findViewById(R.id.result1);
        Goo = findViewById(R.id.Goo);
    }
}
