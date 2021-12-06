package com.kodilla.advancedGame;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class RPSGameApplication
{
    static HighScoreDatabase highScoreDatabase = new HighScoreDatabase();
    static Scanner scanner = new Scanner(System.in);

    static final String filePath = "D:/Database/highScores.txt";

    public static void main(String[] args) throws IOException
    {
        highScoreDatabase.loadFromFile(filePath);

        int playerPoints = 0;
        int computerPoints = 0;
        int currentRound = 0;
        String playerName;

        do
        {
            System.out.print("Enter Your Name: ");
            playerName = scanner.nextLine();

            if (playerName.isEmpty())
                System.out.println("Name Can Not Be Empty!");
        }
        while (playerName.isEmpty());


        RPSDifficulty difficulty = getRpsDifficulty();
        char gameType = getGameType();
        int roundsCount = getRoundCount();

        while (currentRound < roundsCount)
        {
            System.out.println();
            System.out.println("Round: " + (currentRound + 1) + " of " + roundsCount +
                    " Your Points: " + playerPoints + " Computer Points " + computerPoints);

            System.out.print("Enter Your Move: ");

            Set<Character> options = Set.of('x');

            if (gameType == 's')
            {
                System.out.print("(R)ock, (P)aper, (S)cissors, E(x)it: ");
                options = Set.of('r', 'p', 's','x');
            }
            else if (gameType == 'a')
            {
                System.out.print("(R)ock, (P)aper, (S)cissors, (L)izard, Sp(o)ck \t Or Press (X) to Exit: ");
                options = Set.of('r', 'p', 's', 'l', 'o', 'x');
            }

            char selection = ' ';

            do
            {
                String input = scanner.nextLine().toLowerCase();

                if (!input.isEmpty())
                {
                    selection = input.charAt(0);
                    if (!options.contains(selection))
                        System.out.println("Wrong Letter!");
                }
            }
            while (!options.contains(selection));

            if (selection == 'x')
                break;

            RPSMove playerMove = RPSMove.fromChar(selection);

            RPSMove computerMove = RPSMove.getComputerMove(gameType, difficulty, playerMove);

            RPSResult playerResult = RPSResult.checkResult(gameType, playerMove, computerMove);

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

        System.out.println();
        System.out.println("Game Result --> " + gameResult.name());

        HighScore highScore = new HighScore(playerName, playerPoints, computerPoints, gameType, difficulty, gameResult);
        highScoreDatabase.AddScore(highScore);
        highScoreDatabase.SaveToFile(filePath);
    }

    private static int getRoundCount()
    {
        int roundsCount = 0;
        boolean correctValue = true;

        do
        {
            try
            {
                System.out.print("How Many Rounds Would You Like To Play?: ");
                roundsCount = Integer.parseInt(scanner.nextLine());
                correctValue = true;
            }
            catch (Exception e)
            {
                if (!correctValue || roundsCount <= 0)
                {
                    correctValue = false;
                    System.out.println("Incorrect Value!");
                }
            }
        }
        while (!correctValue);

        return roundsCount;
    }

    private static char getGameType()
    {
        Set<Character> gameTypeSet = Set.of('a', 's');
        char gameTypeSelection = '\n';

        do
        {
            try
            {
                System.out.print("Choose Game Type, (S)imple or (A)dvanced Witch More Move Options: ");
                gameTypeSelection = scanner.nextLine().toLowerCase().charAt(0);
            }
            catch (Exception e)
            {
                if (!gameTypeSet.contains(gameTypeSelection) || gameTypeSelection == '\n')
                    System.out.println("Wrong Letter!");
            }
        }
        while (!gameTypeSet.contains(gameTypeSelection));

        return gameTypeSelection;
    }

    private static RPSDifficulty getRpsDifficulty()
    {
        Set<Character> difficultyOptions = Set.of('e', 'n', 'h');
        char difficultySelection = ' ';

        do
        {
            try
            {
                System.out.print("Choose Difficulty: (E)asy, (N)ormal, (H)ard: ");
                difficultySelection = scanner.nextLine().toLowerCase().charAt(0);
            }
            catch (Exception e)
            {
                if (!difficultyOptions.contains(difficultySelection))
                    System.out.println("Wrong Letter!");
                else if (difficultySelection == ' ')
                    System.out.println("Input Can Not Be Empty!");
            }
        }
        while (!difficultyOptions.contains(difficultySelection));

        RPSDifficulty difficulty = RPSDifficulty.fromChar(difficultySelection);
        return difficulty;
    }
}
