package com.kodilla.rps_game;

import java.util.Random;

enum RPSMove
{
    Rock(114), Paper(112), Scissors(115);
    private int rpsMove;

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
            case ('r'): return RPSMove.Rock;
            case ('p'): return RPSMove.Paper;
            case ('s'): return RPSMove.Scissors;

            default: throw new IllegalArgumentException("Conversion Failed!");
        }
    }
}

enum RPSResult
{
    Win, Lose, Tie;
}

public class RPSGame
{
    public RPSMove computerMove()
    {
        RPSMove[] rps = RPSMove.values();
        RPSMove computerMove = rps[new Random().nextInt(rps.length)];

        return computerMove;
    }

    // Compares two players move, and returns result for player one
    RPSResult checkResult(RPSMove player1Move, RPSMove player2Move)
    {
        if(player1Move.equals(player2Move))
            return RPSResult.Tie;

        if(player1Move == RPSMove.Paper)
        {
            switch (player2Move)
            {
                case Rock:
                    return RPSResult.Win;
                case Scissors:
                    return RPSResult.Lose;
            }
        }
        else if (player1Move == RPSMove.Rock)
        {
            switch (player2Move)
            {
                case Paper:
                    return RPSResult.Lose;
                case Scissors:
                    return RPSResult.Win;
            }
        }
        else if (player1Move == RPSMove.Scissors)
        {
            switch (player2Move)
            {
                case Paper:
                    return RPSResult.Win;
                case Rock:
                    return RPSResult.Lose;
            }
        }

        throw new IllegalArgumentException("Result Check Failed!");
    }
}
