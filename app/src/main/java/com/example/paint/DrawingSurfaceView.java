package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
        // Get the dimensions of the drawing surface
        int width = getWidth();
        int height = getHeight();

        // Create a bitmap and an associated canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    // Handle a touch screen event
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //
                break;
            case MotionEvent.ACTION_MOVE:
                //
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
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
