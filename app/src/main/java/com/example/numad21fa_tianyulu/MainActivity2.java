package com.example.numad21fa_tianyulu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;
    private TextView view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnA = findViewById(R.id.button3);
        btnB = findViewById(R.id.button4);
        btnC = findViewById(R.id.button5);
        btnD = findViewById(R.id.button6);
        btnE = findViewById(R.id.button7);
        btnF = findViewById(R.id.button8);
        view2 = findViewById(R.id.textView2);

        btnA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: A");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });

        btnB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: B");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });

        btnC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: C");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });

        btnD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: D");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });

        btnE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: E");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });

        btnF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    view2.setText("Pressed: F");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    view2.setText("Pressed: -");
                }
                return false;
            }
        });







    }
}