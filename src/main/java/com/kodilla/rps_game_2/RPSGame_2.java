package com.kodilla.rps_game_2;

import java.util.Random;

enum RPSMove
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
}
enum RPSResult
{
    WIN, LOSE, TIE;
}

public class RPSGame_2
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
        if (player1Move.equals(player2Move))
            return RPSResult.TIE;

        if (player1Move == RPSMove.ROCK)
        {
            switch (player2Move)
            {
                case PAPER:
                    return RPSResult.LOSE;
                case SCISSORS:
                    return RPSResult.WIN;
                case LIZARD:
                    return RPSResult.WIN;
                case SPOCK:
                    return RPSResult.LOSE;
            }
        }
        else if (player1Move == RPSMove.PAPER)
        {
            switch (player2Move)
            {
                case ROCK:
                    return RPSResult.WIN;
                case SCISSORS:
                    return RPSResult.LOSE;
                case LIZARD:
                    return RPSResult.LOSE;
                case SPOCK:
                    return RPSResult.WIN;
            }
        }
        else if (player1Move == RPSMove.SCISSORS)
        {
            switch (player2Move)
            {
                case ROCK:
                    return RPSResult.LOSE;
                case PAPER:
                    return RPSResult.WIN;
                case LIZARD:
                    return RPSResult.WIN;
                case SPOCK:
                    return RPSResult.LOSE;
            }
        }
        else if (player1Move == RPSMove.LIZARD)
        {
            switch (player2Move)
            {
                case ROCK:
                    return RPSResult.LOSE;
                case PAPER:
                    return RPSResult.WIN;
                case SCISSORS:
                    return RPSResult.LOSE;
                case SPOCK:
                    return RPSResult.WIN;
            }
        }
        else if (player1Move == RPSMove.SPOCK)
        {
            switch (player2Move)
            {
                case ROCK:
                    return RPSResult.WIN;
                case PAPER:
                    return RPSResult.LOSE;
                case SCISSORS:
                    return RPSResult.WIN;
                case LIZARD:
                    return RPSResult.LOSE;
            }
        }

        throw new IllegalArgumentException("Result Check Failed!");
    }
}
