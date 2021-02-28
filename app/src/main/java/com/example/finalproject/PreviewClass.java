package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.List;

public class PreviewClass extends SurfaceView implements SurfaceHolder.Callback{
     Camera camera;
     SurfaceHolder holder;


    public PreviewClass(Context context) {
        super(context);
    }

    public PreviewClass(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        holder= getHolder();
        holder.addCallback(this);
    }


    public static void setCameraDisplayOrientation(Activity activity, int cameraId, Camera camera){

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Camera.Parameters params = camera.getParameters();

        //get the right size
        List<Camera.Size> sizes = params.getSupportedPictureSizes();
        Camera.Size mSize=null;

        for(Camera.Size size : sizes){
            mSize=size;
        }


        //change orientation
        if(this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE){
            params.set("orientation","portrait");
            camera.setDisplayOrientation(90);
            params.setRotation(90);
        }
        else{
            params.set("orientation","landscape");
            camera.setDisplayOrientation(0);
            params.setRotation(0);
        }

        params.setPictureSize(mSize.width,mSize.height);
        camera.setParameters(params);
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        setCameraDisplayOrientation((Activity)getContext(), Camera.CameraInfo.CAMERA_FACING_BACK, camera);
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size bestSize = null;
        for (Camera.Size size : parameters.getSupportedPictureSizes()){
            if (size.width <= i1 && size.height <=i2) {
                if (bestSize == null) {
                    bestSize = size;
                } else {
                    int bestArea = bestSize.width * bestSize.height;
                    int newArea = size.width * size.height;

                    if (newArea > bestArea){
                        bestSize = size;
                    }
                }
            }
        }

        parameters.setPictureSize(bestSize.width, bestSize.height);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        camera.setParameters(parameters);

        try{
            camera.setPreviewDisplay(surfaceHolder);
        }catch (IOException e){
            e.printStackTrace();
        }

        camera.startPreview();


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        camera.stopPreview();
        camera.release();
        camera = null;
    }


}