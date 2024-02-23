package com.example.anneliesewaltersfacemakerhomework;

import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.content.Context;
import android.util.AttributeSet;

/* @author Anneliese Walters

 */

public class Face extends SurfaceView {
    private int skinColor;
   private int eyeColor;
   private int hairColor;
    private int hairStyle;

    Paint hairPaint = new Paint();

    // method to create and initialize instance variables at random values at start
    public void randomize(){
        Random random = new Random();
        skinColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        eyeColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        hairColor = Color.rgb(random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
        hairStyle = random.nextInt(3);

        //set hair paint color
        hairPaint.setColor(hairColor);
        invalidate();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        randomize();
        setWillNotDraw(false);
    }

    //draw eyes
    private void drawEyes(Canvas canvas){
        Paint eyePaint = new Paint();
        eyePaint.setColor(eyeColor);
        canvas.drawCircle(canvas.getWidth()/2+100, canvas.getHeight()/2-100, 90,eyePaint);
        canvas.drawCircle(canvas.getWidth()/2-100,canvas.getHeight()/2-100,90,eyePaint);
    }

    private void drawFace(Canvas canvas){
        Paint facePaint = new Paint();
        facePaint.setColor(skinColor);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2, 400, facePaint);
    }

    //draw mouth
    private void drawMouth(Canvas canvas){
        Paint mouthPaint = new Paint();
        mouthPaint.setColor(Color.BLACK);
        canvas.drawArc(canvas.getWidth()/2-100,
                canvas.getHeight()/2+50,
                canvas.getWidth()/2+100,
                canvas.getHeight()/2+200,
                0,
                180,
                false,
                mouthPaint);

        /**
         External Citation
         Date:     22 February 2024
         Problem:  had to figure out how to draw arc
         Resource:
         Android SDK
         */
    }

    //draw hair
    private void drawStraightHair(Canvas canvas) {
        //Straight hair
        canvas.drawRect(canvas.getWidth() / 2 - 430,
                canvas.getHeight() / 2 + 455,
                canvas.getWidth() / 2 + 430,
                canvas.getHeight() / 2,
                hairPaint);
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 430, hairPaint);
    }

    private void drawBaldHair(Canvas canvas){
        //bald headed
    }

    private void drawAfroHair(Canvas canvas) {
        //big Afro
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 600, hairPaint);
        }

    //set hair style to int place in array
    public void setHairStyle(int num){
        hairStyle = num;
    }

    // array to store rgb values
    int[] rgb = new int[3];
    //get rgb value of hair, eyes, and skin and store it in the array
    public int[] getHair(){
        rgb[0] = Color.red(hairColor);
        rgb[1] = Color.green(hairColor);
        rgb[2] = Color.blue(hairColor);
        return rgb;
    }
    public int[] getEyes(){
        rgb[0] = Color.red(eyeColor);
        rgb[1] = Color.green(eyeColor);
        rgb[2] = Color.blue(eyeColor);
        return rgb;
    }
    public int[] getSkin(){
        rgb[0] = Color.red(skinColor);
        rgb[1] = Color.green(skinColor);
        rgb[2] = Color.blue(skinColor);
        return rgb;
    }

    /**
     External Citation
     Date:     22 February 2024
     Problem:  needed help creating the array and changing the values
     Resource:
     StackOverFlow
     */

    //set hair color
    public void setHairColor(int color){
        this.hairColor = color;
        hairPaint.setColor(hairColor);
        invalidate();
    }
    //set eye color
    public void setEyeColor(int color){
        this.eyeColor = color;
    }
    //set skin color
    public void setSkinColor(int color){
        this.skinColor = color;
    }

public void onDraw(Canvas canvas){
   if(hairStyle == 0){
        drawStraightHair(canvas);
    }
    else if(hairStyle == 1){
        drawBaldHair(canvas);
    }
    else if(hairStyle == 2){
        drawAfroHair(canvas);
    }
    drawFace(canvas);
    drawEyes(canvas);
    drawMouth(canvas);
}
}
