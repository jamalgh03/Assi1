package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class act2 extends AppCompatActivity {
    private EditText txt1;
    private EditText txt2;
    private TextView Res;
    private Button calculate;
    private Button go;
    private TextView res2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        ImageView imageView = findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ass_photo);

        findview();


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplay();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Go();

            }
        });
    }


    private void Go() {
        Intent intent = new Intent(this, Act3.class);
        startActivity(intent);
    }

    private void calculateAndDisplay() {
        try {
            String num1Str = txt1.getText().toString();
            String num2Str = txt2.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Res.setText("Please enter numbers");
                return;
            }

            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Check if numbers are within the required range
            if (num1 < 0 || num1 > 9 || num2 < 0 || num2 > 9) {
                Res.setText("Please enter valid numbers between 0 and 9");
                return;
            }

            int product = num1 * num2;
            res2.setText("=" + product); // Display the product in res2

            List<String> results = new ArrayList<>();
            Random random = new Random();

            for (int count = 0; count < 10; count++) {
                int randomNum1 = random.nextInt(product + 1);
                int randomNum2 = product - randomNum1;
                results.add(randomNum1 + " + " + randomNum2);
            }

            StringBuilder sb = new StringBuilder();
            for (String result : results) {
                sb.append(result).append("\n");
            }
            Res.setText(sb.toString());
        } catch (NumberFormatException e) {
            // Handle the case when input strings cannot be parsed to integers
            Res.setText("Please enter valid integer numbers");
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            Res.setText("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    private void findview() {
        calculate = findViewById(R.id.claculate);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        Res = findViewById(R.id.result1);
        go = findViewById(R.id.Go);
        res2 = findViewById(R.id.res2);

    }
}
