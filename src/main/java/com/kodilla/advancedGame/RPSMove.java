package com.kodilla.advancedGame;

import java.util.Random;

public enum RPSMove
{
    ROCK(114), PAPER(112), SCISSORS(115), LIZARD(108), SPOCK(111);
    private final int rpsMove;

    RPSMove(int rpsMove)
    {
        this.rpsMove = rpsMove;
    }

    public int getRpsMove()
    {
        return rpsMove;
    }

    public static RPSMove fromChar(char ch)
    {
        switch (ch)
        {
            case ('r'): return RPSMove.ROCK;
            case ('p'): return RPSMove.PAPER;
            case ('s'): return RPSMove.SCISSORS;
            case ('l'): return RPSMove.LIZARD;
            case ('o'): return RPSMove.SPOCK;

            default: throw new IllegalArgumentException("Conversion Failed!");
        }
    }

    public static RPSMove getComputerMove(char gameType, RPSDifficulty difficulty, RPSMove playerMove)
    {
        double weightMultiplier = 1;

        switch (difficulty)
        {
            case EASY:
                weightMultiplier = 1;
                break;
            case NORMAL:
                weightMultiplier = (gameType == 's') ? 1.45 : 1.5;
                break;
            case HARD:
                weightMultiplier = (gameType == 's') ? 2 : 2.25;
                break;

            default: throw new IllegalArgumentException("Invalid Difficulty!");
        }

        RPSMove[] rps = {};

        if (gameType == 's')
            rps = new RPSMove[]{RPSMove.ROCK, RPSMove.PAPER, RPSMove.SCISSORS};
        else if (gameType == 'a')
            rps = RPSMove.values();
        else throw new IllegalArgumentException("Invalid Game Type!");

        double[] weights = new double[rps.length];

        double weightsSum = 0;

        for (int i = 0; i < weights.length; i++)
        {
            RPSResult potentialResult = RPSResult.checkResult(gameType, rps[i], playerMove);
            switch (potentialResult)
            {
                case WIN:
                    weights[i] = 1.0 * weightMultiplier;
                    break;
                case LOSE:
                case TIE:
                    weights[i] = 1;
                    break;
                default: throw new IllegalArgumentException("Invalid Result!");
            }
            weightsSum += weights[i];
        }

        double[] ranges = new double[rps.length];

        for (int i = 0; i < weights.length; i++)
           ranges[i] = ((i == 0) ? 0 : ranges[i - 1]) + (weights[i] / weightsSum);

        RPSMove computerMove = rps[0];

        Random random = new Random();
        double x = random.nextDouble();

        for (int i = 1; i < weights.length; i++)
        {
            if (x >= ranges[i - 1] && x <= ranges[i])
                computerMove = rps[i];
        }

        return computerMove;
    }
}
