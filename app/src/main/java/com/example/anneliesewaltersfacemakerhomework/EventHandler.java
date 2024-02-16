
/* @author Anneliese Walters

 */


package com.example.anneliesewaltersfacemakerhomework;

import android.widget.SeekBar;
import android.widget.TextView;

public class EventHandler implements SeekBar.OnSeekBarChangeListener {

    private MainActivity myActivity;

    public EventHandler(MainActivity initActivity) {
        myActivity = initActivity;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // gives app the ability to identify which seek bar is being touched and where then updates
        // textview accordingly by referencing layout

        int seekBarId = seekBar.getId();

        if (seekBarId == R.id.redSeekBar) {
            TextView tvRed = myActivity.findViewById(R.id.redScore);
            tvRed.setText("" + progress);
        }

        else if (seekBarId == R.id.blueSeekBar)
            {
                TextView tvBlue = myActivity.findViewById(R.id.blueScore);
                tvBlue.setText("" + progress);
            }
        else if (seekBarId == R.id.greenSeekBar)
        {
            TextView tvGreen = myActivity.findViewById(R.id.greenScore);
            tvGreen.setText("" + progress);
        }

        /**
         External Citation
         Date:     15 February 2024
         Problem:  did not know how to display value of multiple seekbars at one time
         Resource:
         Android SDK
         */

        }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {



    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
