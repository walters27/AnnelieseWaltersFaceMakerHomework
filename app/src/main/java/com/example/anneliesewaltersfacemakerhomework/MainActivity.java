
/* @author Anneliese Walters

 */

package com.example.anneliesewaltersfacemakerhomework;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create EventHandler Object

        EventHandler handler = new EventHandler(this);

       //create seekbar objects to reference seek bars within layout


        SeekBar redSB = findViewById(R.id.redSeekBar);
        redSB.setOnSeekBarChangeListener(handler);

        SeekBar greenSB = findViewById(R.id.greenSeekBar);
        greenSB.setOnSeekBarChangeListener(handler);

        SeekBar blueSB = findViewById(R.id.blueSeekBar);
        blueSB.setOnSeekBarChangeListener(handler);

        // add items to spinner
        String[] arraySpinner = new String[] {
                "Bald", "Curly", "Straight"
        };

        Spinner s = (Spinner) findViewById(R.id.styleSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        /**
         External Citation
         Date:     15 February 2024
         Problem:  did not know how to add items to spinner
         Resource:
        Android SDK
         */






    }

    }
