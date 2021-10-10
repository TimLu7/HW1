package com.example.numad21fa_tianyulu;

import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Locator extends AppCompatActivity {

    private LocationManager locationmanager;
    private String enableGPS = "Please enable GPS to get your location";
    private String loadGPS = "GPS loading...";
    private String location = "Latitude: %s \n Longtitude: %s";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
    }




}
