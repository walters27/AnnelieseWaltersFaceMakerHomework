package com.example.anneliesewaltersfacemakerhomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

/* @author Anneliese Walters

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create face object
        Face face = findViewById(R.id.surfaceView);

        //create EventHandler object
        EventHandler handler = new EventHandler(this,face);

        //Register controller object with the seekbar
        SeekBar redSB = findViewById(R.id.redSeekBar);
        redSB.setOnSeekBarChangeListener(handler);

        SeekBar greenSB = findViewById(R.id.greenSeekBar);
        greenSB.setOnSeekBarChangeListener(handler);

        SeekBar blueSB = findViewById(R.id.blueSeekBar);
        blueSB.setOnSeekBarChangeListener(handler);

        Spinner hairStyleSpinner = findViewById(R.id.styleSpinner);
        hairStyleSpinner.setOnItemSelectedListener(handler);

        RadioButton hairButton = findViewById(R.id.radioButtonHair);
        hairButton.setOnCheckedChangeListener(handler);

        RadioButton eyesButton = findViewById(R.id.radioButtonEyes);
        eyesButton.setOnCheckedChangeListener(handler);

        RadioButton skinButton = findViewById(R.id.radioButtonSkin);
        skinButton.setOnCheckedChangeListener(handler);

        Button rand = findViewById(R.id.button);
        rand.setOnClickListener(handler);


    }
}
