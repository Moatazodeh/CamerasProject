package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Open();
          }

        });
    }

    public void Open() {
        try {
            // intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            Intent intent = new Intent(this,cameras.class);
            startActivity(intent);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ed'a la2 rj3ha 3la 2lb onCreate m3 onClick listener  .......................................





}