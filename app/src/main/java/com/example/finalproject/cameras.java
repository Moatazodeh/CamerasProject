package com.example.finalproject;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class cameras extends AppCompatActivity {
    Camera camera = null;
    FrameLayout frameLayout;
    PreviewClass showCameras;
    RelativeLayout simpleRelativeLayout;
    private static final String TAG = "Camera failed to open: ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam);
        //frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        simpleRelativeLayout = (RelativeLayout) findViewById(R.id.relative);


        // static int saveFlag = 0;
        //private ArrayList<Camera> List;
        //@Override
        //public void onCreate(Bundle savedInstanceState) {
        //  List = new ArrayList<>();
        //    super.onCreate(savedInstanceState);
        //      setContentView(R.layout.cam);
//        ListView myList = findViewById(R.id.listView);

        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        System.out.println("number of camerassssssssss= " + numberOfCameras);

        //for (int camIdx = 0; camIdx < numberOfCameras; camIdx++) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(0, info);
        if (info.facing != Camera.CameraInfo.CAMERA_FACING_FRONT) {
            System.out.println("idddddddddddddddd= " + 0);
            try {
                // set the layout params for ImageView
                RelativeLayout.LayoutParams FrameLayoutParam = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                // create a new FrameLayout
                FrameLayout simpleFrameView = (FrameLayout) findViewById(R.id.framelayout);

                simpleFrameView.setLayoutParams(FrameLayoutParam); // set defined layout params to Framelayout
                FrameLayoutParam.addRule(RelativeLayout.CENTER_HORIZONTAL); // align ImageView in the center
                // add ImageView in RelativeLayout



                // open camera .....
                System.out.println("aaaaa");
                if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 50);
                }
                camera = Camera.open();
                System.out.println("bbbb");
                showCameras = new PreviewClass(this, camera);
                if (simpleFrameView.getParent() != null)
                    ((ViewGroup) simpleFrameView.getParent()).removeView(simpleFrameView);
                simpleFrameView.addView(showCameras);
                simpleRelativeLayout.addView(simpleFrameView, 0);
            } catch (RuntimeException e) {
                Log.e(TAG, "Camera failed to open: " + e.getLocalizedMessage());
            }





                //              if (saveFlag == 1) {

                // save the picture ....................


                //                }

//
                //              }


                //     }


                //   }
            //}


            //  }

       }
    }

    public void onClickClose(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    public void onClickPlay(View view) {
        // saveFlag = 1;

        ImageButton playButton, stopPlayButton;
        playButton = findViewById(R.id.startButton);
        stopPlayButton = findViewById(R.id.stopCameraButton);

        playButton.setVisibility(View.GONE);
        stopPlayButton.setVisibility(View.VISIBLE);
    }

    public void onClickStopCamera(View view) {
        //saveFlag = 0;

        ImageButton playButton, stopPlayButton;
        playButton = findViewById(R.id.startButton);
        stopPlayButton = findViewById(R.id.stopCameraButton);

        playButton.setVisibility(View.VISIBLE);
        stopPlayButton.setVisibility(View.GONE);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    public int getNumberOfCameras() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return ((CameraManager) getSystemService(Context.CAMERA_SERVICE)).getCameraIdList().length;
                }
            } catch (CameraAccessException e) {
                Log.e("", "", e);
            }
        }
        return Camera.getNumberOfCameras();
    }





}