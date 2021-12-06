package com.kodilla.advancedGame;

public class HighScore
{
    private String playerName;
    private int playerPoints;
    private int computerPoints;
    private char gameType;
    private RPSDifficulty gameDifficulty;
    private RPSResult gameResult;

    public String getPlayerName()
    {
        return playerName;
    }

    public int getPlayerPoints()
    {
        return playerPoints;
    }

    public int getComputerPoints()
    {
        return computerPoints;
    }

    public char getGameType()
    {
        return gameType;
    }

    public RPSDifficulty getGameDifficulty()
    {
        return gameDifficulty;
    }

    public RPSResult getGameResult()
    {
        return gameResult;
    }

    public int getScore()
    {
        return playerPoints - computerPoints;
    }

    public HighScore(String playerName, int playerPoints, int computerPoints, char gameType, RPSDifficulty gameDifficulty, RPSResult gameResult)
    {
        this.playerName = playerName;
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
        this.gameType = gameType;
        this.gameDifficulty = gameDifficulty;
        this.gameResult = gameResult;
    }

    public HighScore(String lineFromFile)
    {
        String[] score = lineFromFile.split(";");
        this.playerName = score[0];
        this.playerPoints = Integer.parseInt(score[1]);
        this.computerPoints = Integer.parseInt(score[2]);
        this.gameType = score[3].charAt(0);
        this.gameDifficulty = RPSDifficulty.valueOf(score[4]);
        this.gameResult = RPSResult.valueOf(score[5]);
    }

    public String writeToFile()
    {
        return playerName + ";" + playerPoints + ";" + computerPoints + ";" + gameType + ";" + gameDifficulty.name() + ";" + gameResult.name();
    }

    public String toString()
    {
        return playerName + "\t" + playerPoints + "\t" + computerPoints + "\t" + gameType + "\t" + gameDifficulty.name() + "\t" + gameResult.name();
    }

    public static int compareScores(HighScore o1, HighScore o2)
    {
        if (o1.getScore() > o2.getScore())
            return 1;
        else if (o1.getScore() < o2.getScore())
            return -1;
        else
            return 0;
    }
}
