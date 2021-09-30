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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickyBtn = findViewById(R.id.button2);

        toastButton = findViewById(R.id.button);

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



    }
}