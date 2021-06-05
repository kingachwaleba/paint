package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class DrawingSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    // Enables to control and monitor a drawing surface
    private SurfaceHolder surfaceHolder;

    private Bitmap bitmap = null;
    private Canvas canvas = null;

    public DrawingSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Surface Holder enables to control and monitor a drawing surface
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void run() {
        
    }
}
