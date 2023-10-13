package Dice_Game;

import java.util.Random;

class Dice {
	
    private int faceValue;

    public void roll()
    {
        Random random = new Random();
        faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() 
    {
        return faceValue;
    }
}