package com.example.asus.pantallas_hotelspa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ASUS on 17/02/2018.
 */

public class ReservationService extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_view);
    }
    public void nextActivity(View view){
        startActivity(new Intent(
                this, FinalActivity.class));
        finish();
    }
}
