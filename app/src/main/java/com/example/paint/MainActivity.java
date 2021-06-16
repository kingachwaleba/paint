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
    private String chosenColor = "blue";

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

        redButton.setOnClickListener(v -> {
            chosenColor = "red";
            drawingSurfaceView.setColor(chosenColor);
        });

        yellowButton.setOnClickListener(v -> {
            chosenColor = "yellow";
            drawingSurfaceView.setColor(chosenColor);
        });

        blueButton.setOnClickListener(v -> {
            chosenColor = "blue";
            drawingSurfaceView.setColor(chosenColor);
        });

        greenButton.setOnClickListener(v -> {
            chosenColor = "green";
            drawingSurfaceView.setColor(chosenColor);
        });

        clearButton.setOnClickListener(v -> drawingSurfaceView.clearAll());

        if(savedInstanceState != null){
            Bitmap bitmap = savedInstanceState.getParcelable("bitmap");
            chosenColor = savedInstanceState.getString("color");

            // Set saved bitmap to canvas in DrawingSurfaceView class
            drawingSurfaceView.setBitmap(bitmap);
            drawingSurfaceView.setIfRotated(true);

            // Set saved color
            drawingSurfaceView.setColor(chosenColor);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save current canvas
        outState.putParcelable("bitmap", drawingSurfaceView.getBitmap());
        // Save chosen color
        outState.putString("color", chosenColor);
    }
}