package com.kodilla.advancedGame;

public interface BasicMethods
{
    public RPSMove computerMove();

    RPSResult checkResult(RPSMove player1Move, RPSMove player2Move);
}
