package Dice_Game;

import java.io.*;
import java.util.Scanner;

public class DiceGameWithFileIO {
    private Person playerA;
    private Person playerB;

    public void registerPlayers(Person playerA, Person playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void startGame() {
        playerA.rollDice(new Dice(), new Dice());
        playerB.rollDice(new Dice(), new Dice());

        int[] diceValuesA = playerA.getDiceValues();
        int[] diceValuesB = playerB.getDiceValues();

        System.out.println(playerA.getName() + " rolled " + diceValuesA[0] + " and " + diceValuesA[1] +
                " (Total: " + playerA.getSumOfDice() + ")");
        System.out.println(playerB.getName() + " rolled " + diceValuesB[0] + " and " + diceValuesB[1] +
                " (Total: " + playerB.getSumOfDice() + ")");

        String result = "";

        if (playerA.getSumOfDice() > playerB.getSumOfDice()) {
            System.out.println(playerA.getName() + " wins!");
            result = playerA.getName() + " wins!";
        } else if (playerA.getSumOfDice() < playerB.getSumOfDice()) {
            System.out.println(playerB.getName() + " wins!");
            result = playerB.getName() + " wins!";
        } else {
            int higherValueA = playerA.getHigherDiceValue();
            int higherValueB = playerB.getHigherDiceValue();

            if (higherValueA > higherValueB) {
                System.out.println(playerA.getName() + " wins with the higher individual roll!");
                result = playerA.getName() + " wins with the higher individual roll!";
            } else if (higherValueA < higherValueB) {
                System.out.println(playerB.getName() + " wins with the higher individual roll!");
                result = playerB.getName() + " wins with the higher individual roll!";
            } else {
                System.out.println("It's a tie! No one wins.");
                result = "It's a tie! No one wins.";
            }
        }

        writeGameResultToFile(result, playerA, playerB);
    }

    private void writeGameResultToFile(String result, Person playerA, Person playerB) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true));
            String record = playerA.getName() + " VS " + playerB.getName() + " Winner is " + result +
                    " ( " + playerA.getName() + " rolled " + playerA.getDiceValues()[0] + " and " + playerA.getDiceValues()[1] +
                    " / Total : " + playerA.getSumOfDice() + " ) ( " + playerB.getName() + " rolled " + playerB.getDiceValues()[0] + " and " + playerB.getDiceValues()[1] +
                    " / Total : " + playerB.getSumOfDice() + " )";
            writer.write(record);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DiceGameWithFileIO game = new DiceGameWithFileIO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Start a new game");
            System.out.println("2. View game records");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (option == 1) {
                System.out.println("Enter the name of Player A:");
                String nameA = scanner.nextLine();
                System.out.println("Enter the name of Player B:");
                String nameB = scanner.nextLine();

                Person playerA = new Person(nameA);
                Person playerB = new Person(nameB);

                game.registerPlayers(playerA, playerB);
                game.startGame();
                
                System.out.println("one more game? > Y/N");
                String playAgainOption = scanner.nextLine();
                if (!playAgainOption.equalsIgnoreCase("Y")) {
                    break;
                }
                else if (!playAgainOption.equalsIgnoreCase("N")) {
                	while(true)
                	{
                		game.startGame();
                        System.out.println("one more game? > Y/N");
                        String playAgainOption1 = scanner.nextLine();
                        if (!playAgainOption1.equalsIgnoreCase("Y")) {
                            break;
                        }
                }
            }
                
            } else if (option == 2) {
                viewGameRecords();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
     }
    

    private static void viewGameRecords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("game_results.txt"));
            String line;

            System.out.println("Game Records:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Currently, there are no game records.");
        }
    }
}
