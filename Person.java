package Dice_Game;

class Person {
    private String name;
    private int[] diceValues = new int[2];
    private int sumOfDice;

    public Person(String name) {
        this.name = name;
    }

    public void rollDice(Dice dice1, Dice dice2) {
        dice1.roll();
        dice2.roll();
        diceValues[0] = dice1.getFaceValue();
        diceValues[1] = dice2.getFaceValue();
        sumOfDice = diceValues[0] + diceValues[1];
    }

    public int getSumOfDice() {
        return sumOfDice;
    }

    public int getHigherDiceValue() {
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