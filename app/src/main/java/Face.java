/* @author Anneliese Walters

 */

import java.util.Random;

public class Face {
    public int skinColor;
   public int eyeColor;
   public int hairColor;
    public int hairStyle;

    public Face(){
    randomize();
    }



    // method to create and initialize instance variables at random values at start
    public void randomize(){
Random rand = new Random();
skinColor = rand.nextInt(3);
eyeColor = rand.nextInt(255);
hairColor = rand.nextInt(255);
hairStyle = rand.nextInt(3);
    }

public void onDraw(){


}



// on Draw helper methods
public void drawEyes(){


}


public void drawHair(){



}

}
