package com.kodilla.advancedGame;

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
}
