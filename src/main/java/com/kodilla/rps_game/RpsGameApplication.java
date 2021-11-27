package com.kodilla.rps_game;

import java.util.Scanner;
import java.util.Set;

public class RpsGameApplication
{
    static Scanner scanner = new Scanner(System.in);
    static RPSGame rpsGame = new RPSGame();
    String name;

    public static void main(String[] args)
    {
        String name;
        int roundsCount;
        int playerPoints = 0;
        int computerPoints = 0;

        System.out.print("Enter Your Name: ");
        name = scanner.nextLine();

        System.out.print("How Many Rounds Would You Like To Play: ");
        roundsCount = Integer.parseInt(scanner.nextLine());

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
                case Lose:
                    System.out.println("You Lose!");
                    computerPoints++;
                    break;
                case Win:
                    System.out.println("You Win!");
                    playerPoints++;
                    break;
                case Tie:
                    System.out.println("Tie!");
                    break;
            }

            currentRound++;
        }

        RPSResult gameResult = RPSResult.Tie;

        if (playerPoints > computerPoints)
            gameResult = RPSResult.Win;
        else if (playerPoints < computerPoints)
            gameResult = RPSResult.Lose;

        System.out.println("Game Result: " + gameResult.name());
    }

}
