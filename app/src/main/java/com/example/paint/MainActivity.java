package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}