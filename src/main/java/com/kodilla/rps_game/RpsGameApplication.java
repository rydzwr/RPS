package com.kodilla.rps_game;

import java.util.Scanner;

public class RpsGameApplication
{
    Scanner scanner = new Scanner(System.in);
    String name;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            String name;
            int roundsCount;

            System.out.println("Enter Your Name:");
            name = scanner.nextLine();

            System.out.println("How Many Rounds Would You Like To Play:");
            roundsCount = scanner.nextInt();

            char choose;
            do
            {
                System.out.println("Enter Your Move: ");
                System.out.println("Rock --> R");
                System.out.println("Paper --> P");
                System.out.println("Scissors --> S");

                choose = scanner.nextLine().toLowerCase().charAt(0);

                if (!(choose == 'r' || choose == 'p' || choose == 's'))
                {
                    System.out.println("Wrong Letter!");
                }
            }
            while (!(choose == 'r' || choose == 'p' || choose == 's'));

            if (choose == 'r')
            {
                System.out.println("Your Move --> Rock || Computer Move --> ");
                System.out.println("Result --> ");
            }
            else if (choose == 'p')
            {
                System.out.println("Your Move --> Paper || Computer Move --> ");
                System.out.println("Result --> ");
            }
            else if (choose == 's')
            {
                System.out.println("Your Move --> Scissors || Computer Move --> ");
                System.out.println("Result --> ");
            }
        }
    }
}
