package com.kodilla.rps_game_2;

import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class RPSGameApplication_2
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String playerName;
        int roundsCount = 0;
        int playerPoints = 0;
        int computerPoints = 0;

        boolean correctName = true;

        do
        {
            try
            {
                System.out.print("Enter Your Name or Nickname: ");
                playerName = scanner.nextLine();
                correctName = true;
            }
            catch (Exception e)
            {
                correctName = false;
                System.out.println("Enter Correct Name!");
            }
        }
        while (!correctName);

        int currentRound = 0;
        while (currentRound < roundsCount)
        {
            System.out.println();
            System.out.println("Round: " + (currentRound + 1) + " of " + roundsCount +
                    " Your Points: " + playerPoints + " Computer Points: " + computerPoints);

            System.out.println("Enter Your Move: ");
            System.out.print("(R)ock, (P)aper, (S)cissors, (L)izard, Sp(o)ck \t Or Press (X) to Exit");

            char selection;
            Set<Character> options = Set.of('r', 'p', 's', 'l', 'o', 'x');

            do
            {
                selection = scanner.nextLine().toLowerCase().charAt(0);

                if (!options.contains(selection))
                    System.out.println("Wrong Letter!");
            }
            while (!options.contains(selection));

            if (selection == 'x')
                break;

        }
    }
}
