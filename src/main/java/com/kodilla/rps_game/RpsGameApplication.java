package com.kodilla.rps_game;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class RpsGameApplication
{
    static HighScoreDatabase highScoreDatabase = new HighScoreDatabase();
    static Scanner scanner = new Scanner(System.in);
    static RPSGame rpsGame = new RPSGame();

    static final String filePath = "D:/Database/highScores.txt";

    public static void main(String[] args) throws IOException
    {
        highScoreDatabase.LoadFromFile(filePath);

        String playerName;
        int roundsCount = 0;
        int playerPoints = 0;
        int computerPoints = 0;

        System.out.print("Enter Your Name: ");
        playerName = scanner.nextLine();
        boolean correctValue = true;

        System.out.print("How Many Rounds Would You Like To Play: ");
        do
        {
            try
            {
                roundsCount = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e)
            {
                correctValue = false;
            }
        }
        while (!correctValue);

        int currentRound = 0;

        while (currentRound < roundsCount)
        {
            System.out.println();
            System.out.println("Round: " + (currentRound+ 1) + " of " + roundsCount +
                    " Your Points: " + playerPoints + " Computer Points " + computerPoints);

            System.out.println("Enter Your Move: ");
            System.out.print("(R)ock, (P)aper, (S)cissors, E(x)it: ");

            char selection;
            Set<Character> options = Set.of('r', 'p', 's', 'x');

            do
            {
                selection = scanner.nextLine().toLowerCase().charAt(0);

                if (!options.contains(selection))
                    System.out.println("Wrong Letter!");

            } while (!options.contains(selection));

            if (selection == 'x')
                break;

            RPSMove playerMove = RPSMove.fromChar(selection);
            RPSMove computerMove = rpsGame.computerMove();
            RPSResult playerResult = rpsGame.checkResult(playerMove, computerMove);

            System.out.println();

            System.out.println("Your Move --> " + playerMove.name() + " || Computer Move --> " + computerMove.name());

            switch (playerResult)
            {
                case LOSE:
                    System.out.println("You Lose!");
                    computerPoints++;
                    break;
                case WIN:
                    System.out.println("You Win!");
                    playerPoints++;
                    break;
                case TIE:
                    System.out.println("Tie!");
                    break;
            }

            currentRound++;
        }

        RPSResult gameResult = RPSResult.TIE;

        if (playerPoints > computerPoints)
            gameResult = RPSResult.WIN;
        else if (playerPoints < computerPoints)
            gameResult = RPSResult.LOSE;

        System.out.println("Game Result: " + gameResult.name());

        HighScore highScore = new HighScore(playerName, playerPoints, computerPoints, gameResult);
        highScoreDatabase.AddScore(highScore);
        highScoreDatabase.SaveToFile(filePath);

    }

}
