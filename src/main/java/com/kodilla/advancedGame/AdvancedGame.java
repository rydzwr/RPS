package com.kodilla.advancedGame;

import java.util.Random;

public class AdvancedGame implements BasicMethods
{
    @Override
    public RPSMove computerMove()
    {
        RPSMove[] rps = RPSMove.values();
        RPSMove computerMove = rps[new Random().nextInt(rps.length)];

        return computerMove;
    }

    @Override
    public RPSResult checkResult(RPSMove player1Move, RPSMove player2Move)
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
