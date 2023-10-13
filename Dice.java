package Dice_Game;

import java.util.Random;

/// Dice 객체는 간단하게 1 ~ 6 중 하나의 값을 생성 후, 가지고 있고 반환합니다.
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

