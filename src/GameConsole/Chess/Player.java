package GameConsole.Chess;

import GameConsole.Chess.piece.PieceColor;


public class Player {
    private String name;
    private PieceColor color;
    private int gameWins, gameLosses, playerScore, totalPlayers;
    private boolean playerWon;


    public Player(String name) {
        this.name = name;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    //getter for player attributes

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }

    public int getGameWins() {
        return gameWins;
    }

    public int getGameLoses() {
        return gameLosses;
    }

    public int getPlayerScore() {
        return playerScore;
    }


}