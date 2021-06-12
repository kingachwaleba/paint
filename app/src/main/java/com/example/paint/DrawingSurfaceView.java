package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
    private Paint paint;
    private Paint bitmapPaint;
    private Path path;

    public DrawingSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Surface Holder enables to control and monitor a drawing surface
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        setWillNotDraw(false);

        paint = new Paint();
        path = new Path();
        // DITHER_FLAG - Paint flag that enables dithering when blitting
        bitmapPaint = new Paint(Paint.DITHER_FLAG);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        // Get the dimensions of the drawing surface
        int width = getWidth();
        int height = getHeight();

        // Create a bitmap and an associated canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawARGB(255, 255, 255, 255);
    }

    // Handle a touch screen event
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // When user touch the screen
                path.reset();
                canvas.drawCircle(event.getX(), event.getY(), 10, paint);
                path.moveTo(event.getX(), event.getY());
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                // When user swiped the screen
                path.lineTo(event.getX(), event.getY());
                canvas.drawPath(path, paint);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                // When user stopped touching the screen
                path.reset();
                canvas.drawCircle(event.getX(), event.getY(), 10, paint);
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
        canvas.drawPath(path, paint);
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

    public void setColor(String color) {
        switch (color) {
            case "red":
                paint.setColor(Color.RED);
                break;
            case "yellow":
                paint.setColor(Color.YELLOW);
                break;
            case "blue":
                paint.setColor(Color.BLUE);
                break;
            case "green":
                paint.setColor(Color.GREEN);
                break;
        }
    }

    public void clearAll() {
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        invalidate();
    }
}
