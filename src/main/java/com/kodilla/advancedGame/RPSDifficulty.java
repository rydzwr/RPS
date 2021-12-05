package com.kodilla.advancedGame;

public enum RPSDifficulty
{
    EASY, NORMAL, HARD;

    static RPSDifficulty fromChar(char ch)
    {
        switch (ch)
        {
            case ('e'): return RPSDifficulty.EASY;
            case ('n'): return RPSDifficulty.NORMAL;
            case ('h'): return RPSDifficulty.HARD;

            default: throw new IllegalArgumentException("Conversion Failed!");
        }
    }
}

