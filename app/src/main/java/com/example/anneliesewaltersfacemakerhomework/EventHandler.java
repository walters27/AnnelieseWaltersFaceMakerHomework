package com.example.anneliesewaltersfacemakerhomework;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Anneliese Walters
 */
public class EventHandler implements SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener,
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener {
    private MainActivity myActivity;
    private Face face;

    public EventHandler(MainActivity initActivity, Face faces){
        myActivity = initActivity;
        this.face = faces;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //get seek bar ID
        int seekBarId = seekBar.getId();
        //get rgb values from seek bars
        int red=((SeekBar) myActivity.findViewById(R.id.redSeekBar)).getProgress();
        int green=((SeekBar) myActivity.findViewById(R.id.greenSeekBar)).getProgress();
        int blue=((SeekBar) myActivity.findViewById(R.id.blueSeekBar)).getProgress();

        //reference text view and set value equal to progress
        if (seekBarId == R.id.redSeekBar){
            TextView maxTV1 = myActivity.findViewById(R.id.redView);
            maxTV1.setText("" + progress);
            //get progress of red seek bar
            red = progress;
        }
        else if (seekBarId == R.id.greenSeekBar){
            TextView maxTV2 = myActivity.findViewById(R.id.greenView);
            maxTV2.setText("" + progress);
            //get progress of green seek bar
            green = progress;
        }
        else if (seekBarId == R.id.blueSeekBar){
            TextView maxTV3 = myActivity.findViewById(R.id.blueView);
            maxTV3.setText("" + progress);
            //get progress of blue seek bar
            blue = progress;
        }

        if(fromUser){
            //if button is clicked, set rgb value to progress rgb values
            if(buttonClicked == hair){
                face.setHairColor(Color.rgb(red,green,blue));
            }
            else if(buttonClicked == eyes){
                face.setEyeColor(Color.rgb(red,green,blue));
            }
            else if(buttonClicked == skin){
                face.setSkinColor(Color.rgb(red,green,blue));
            }
            face.invalidate();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //use setter method to set hair style depending on spinner selected
        face.setHairStyle(position);
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //get id of radio buttons
    int hair = R.id.radioButtonHair;
    int eyes = R.id.radioButtonEyes;
    int skin = R.id.radioButtonSkin;

    int buttonClicked;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //see which feature button was checked
            if (buttonView.getId() == eyes) {
                //use getter method to get rgb values of the feature
                // and place them into new array
                int[] eyeColor = face.getEyes();
                //use helper method to set rgb value on seek bars
                updateSeekBar(eyeColor[0], eyeColor[1], eyeColor[2]);
                //make buttonClicked equal to the button clicked
                buttonClicked = eyes;
            } else if (buttonView.getId() == hair) {
                int[] hairColor = face.getHair();
                updateSeekBar(hairColor[0], hairColor[1], hairColor[2]);
                buttonClicked = hair;
            } else if (buttonView.getId() == skin) {
                int[] skinColor = face.getSkin();
                updateSeekBar(skinColor[0], skinColor[1], skinColor[2]);
                buttonClicked = skin;


                /**
                 External Citation
                 Date:     22 February 2024
                 Problem:  did not understand how to use oncheckedchange method
                 Resource:
                 Android SDK
                 */
            }
        }
    }

    private void updateSeekBar(int redd, int greenn, int bluee){
        //get seek bar id
        SeekBar reds = myActivity.findViewById(R.id.redSeekBar);
        SeekBar greens = myActivity.findViewById(R.id.greenSeekBar);
        SeekBar blues = myActivity.findViewById(R.id.blueSeekBar);

        //set seek bar progress to rgb value
        reds.setProgress(redd);
        greens.setProgress(greenn);
        blues.setProgress(bluee);
    }

    @Override
    public void onClick(View v) {
        face.randomize();
        face.invalidate();
    }
}
