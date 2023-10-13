package Dice_Game;

class Person {
    private String name;
    private int[] diceValues = new int[2]; // 두 게이머의 합이 같을 경우 큰 숫자 비교를 위해 2개의 배열로 받았습니다.
    private int sumOfDice;

    public Person(String name) {
        this.name = name;
    }

    public void rollDice(Dice dice1, Dice dice2) { // 이 부분이 주사위의 각 값과 합산값.
        dice1.roll();
        dice2.roll();
        diceValues[0] = dice1.getFaceValue();
        diceValues[1] = dice2.getFaceValue();
        sumOfDice = diceValues[0] + diceValues[1]; 
    }

    public int getSumOfDice() {
        return sumOfDice;
    }

    public int getHigherDiceValue() { // 여기서 주사위의 가장 큰값을 리턴.
        return Math.max(diceValues[0], diceValues[1]); 
    }
    
    public int[] getDiceValues()
    {
    	return diceValues;
    }

    public String getName() {
        return name;
    }
}
