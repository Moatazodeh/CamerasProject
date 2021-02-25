package com.example.finalproject;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class cameras extends AppCompatActivity {
    Camera camera;
    FrameLayout frameLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam);
        frameLayout = (FrameLayout)findViewById(R.id.framelayout);

        // open camera .....

        camera = Camera.open();































        // private static final String TAG = "Camera failed to open: ";
        // static int saveFlag = 0;
        //private ArrayList<Camera> List;
        //@Override
        //public void onCreate(Bundle savedInstanceState) {
        //  List = new ArrayList<>();
        //    super.onCreate(savedInstanceState);
        //      setContentView(R.layout.cam);
//        ListView myList = findViewById(R.id.listView);


        //Camera cam = null;
        // int cameraId = -1;
        // Search for the front facing camera
        // int numberOfCameras = Camera.getNumberOfCameras();

        //    while (true) {
        // for (int camIdx = 0; camIdx < numberOfCameras; camIdx++) {
        //       Camera.CameraInfo info = new Camera.CameraInfo();
        //         Camera.getCameraInfo(camIdx, info);
        ///            if (info.facing != Camera.CameraInfo.CAMERA_FACING_FRONT) {
//
        //                  try {
        //        cam = Camera.open(camIdx);
        //          List.add(cam);
        //          } catch (RuntimeException e) {
        //            Log.e(TAG, "Camera failed to open: " + e.getLocalizedMessage());
        //            }


        //              if (saveFlag == 1) {

        // save the picture ....................


        //                }

//
        //              }


        //     }


        //   }
        // }

        public void onClickClose () {

            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);


        }


        public void onClickPlay () {

            saveFlag = 1;

            ImageButton playButton, stopPlayButton;
            playButton = findViewById(R.id.startButton);
            stopPlayButton = findViewById(R.id.stopCameraButton);

            playButton.setVisibility(View.GONE);
            stopPlayButton.setVisibility(View.VISIBLE);


        }

        public void onClickStopCamera () {

            saveFlag = 0;

            ImageButton playButton, stopPlayButton;
            playButton = findViewById(R.id.startButton);
            stopPlayButton = findViewById(R.id.stopCameraButton);

            playButton.setVisibility(View.VISIBLE);
            stopPlayButton.setVisibility(View.GONE);


        }


    }