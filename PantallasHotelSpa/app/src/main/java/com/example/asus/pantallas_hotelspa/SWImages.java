package com.example.asus.pantallas_hotelspa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by ASUS on 16/02/2018.
 */

public class SWImages extends AppCompatActivity{
    private ImageSwitcher sw;
    private Button pr,nx;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue_services);
        sw = (ImageSwitcher) findViewById(R.id.imgsw);
        nx = (Button) findViewById(R.id.btn_next);
        pr = (Button) findViewById(R.id.btn_previus);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw.setImageResource(R.drawable.spa1);
            }
        });
        nx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw.setImageResource(R.drawable.spa2);
            }
        });
    }
}
