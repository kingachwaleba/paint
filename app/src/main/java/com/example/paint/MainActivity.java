package com.example.paint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button redButton;
    private Button yellowButton;
    private Button blueButton;
    private Button greenButton;
    private Button clearButton;
    private DrawingSurfaceView drawingSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redButton = findViewById(R.id.red_button);
        yellowButton = findViewById(R.id.yellow_button);
        blueButton = findViewById(R.id.blue_button);
        greenButton = findViewById(R.id.green_button);
        clearButton = findViewById(R.id.clear_all_button);

        drawingSurfaceView = findViewById(R.id.drawing_surface);

        redButton.setOnClickListener(v -> drawingSurfaceView.setColor("red"));
        yellowButton.setOnClickListener(v -> drawingSurfaceView.setColor("yellow"));
        blueButton.setOnClickListener(v -> drawingSurfaceView.setColor("blue"));
        greenButton.setOnClickListener(v -> drawingSurfaceView.setColor("green"));

        clearButton.setOnClickListener(v -> drawingSurfaceView.clearAll());

        if(savedInstanceState != null){
            Bitmap bitmap = savedInstanceState.getParcelable("bitmap");

            // Set saved bitmap to canvas in DrawingSurfaceView class
            drawingSurfaceView.setBitmap(bitmap);
            drawingSurfaceView.setIfRotated(true);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save current canvas
        outState.putParcelable("bitmap", drawingSurfaceView.getBitmap());
    }
}