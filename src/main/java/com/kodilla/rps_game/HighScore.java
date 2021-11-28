package com.kodilla.rps_game;

import java.util.*;
import java.io.*;

public class HighScore
{
    String playerName;
    int playerPoints;
    int computerPoints;
    RPSResult gameResult;

    public void addScore(String playerName, int playerPoints, int computerPoints, RPSResult gameResult) throws IOException
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("RPSGameScores.txt", true));
            writer.write("Name: " + playerName);
            writer.newLine();
            writer.write("Player Points: " + playerPoints + " Computer Points: " + computerPoints);
            writer.newLine();
            writer.write("Game Result: " + gameResult.name());
            writer.newLine();
            writer.newLine();
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Saving Score Failed!");
        }
    }

}
