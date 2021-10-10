package com.example.numad21fa_tianyulu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toastButton;
    private Button clickyBtn;
    private Button linkBtn;
    private Button locatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickyBtn = findViewById(R.id.button2);

        toastButton = findViewById(R.id.button);

        linkBtn = findViewById(R.id.button9);

        locatorBtn = findViewById(R.id.locatorBtn);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Tianyu Lu, lu.tianyu@northeastern.edu",Toast.LENGTH_LONG).show();

            }

        });

        clickyBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        });

        linkBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
        });

        locatorBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this,Locator.class);
            startActivity(intent);
        });

    }
}