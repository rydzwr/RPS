package com.kodilla.advancedGame;

public enum RPSResult
{
    WIN, LOSE, TIE;

    public static RPSResult checkResult(char gameType, RPSMove player1Move, RPSMove player2Move)
    {
        if (gameType == 's')
        {
            if (player1Move.equals(player2Move))
                return RPSResult.TIE;

            if (player1Move == RPSMove.PAPER)
            {
                switch (player2Move)
                {
                    case ROCK:
                        return RPSResult.WIN;
                    case SCISSORS:
                        return RPSResult.LOSE;
                }
            }
            else if (player1Move == RPSMove.ROCK)
            {
                switch (player2Move)
                {
                    case PAPER:
                        return RPSResult.LOSE;
                    case SCISSORS:
                        return RPSResult.WIN;
                }
            }
            else if (player1Move == RPSMove.SCISSORS)
            {
                switch (player2Move)
                {
                    case PAPER:
                        return RPSResult.WIN;
                    case ROCK:
                        return RPSResult.LOSE;
                }
            }
        }

        else if (gameType == 'a')
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
        }

        throw new IllegalArgumentException("Result Check Failed!");
    }
}
