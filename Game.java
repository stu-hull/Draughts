package com.example.stuart.draughts;

// ANNOTATION TERMINOLOGY:
// bMover- a piece which can slide into an adjacent square
// Jumper- a piece which can jump an enemy piece into the square beyond
// LF, RF, LB, RB - Left-forward, right-forward, right-backward, left-backward (from Black's perspective)
// Bitboard- a Long number, 45 bits used to represent some boolean property of every square of a game board, eg, all of the squares with white pieces on
// Mask- like a bitboard, but representing a boolean property universal to all boards, eg, the 32 out of 45 bits which represent valid board locations

// 'currentBoard' refers ONLY to the current gamestate being displayed to the player. For all other hypothetical boards please use 'board'

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    Player player1;
    Player player2;

    Board currentBoard;

    //boolean variables for details of the game- is it against the AI, which player is black, and whose turn it is currently
    boolean againstComputer;
    boolean player1Black;
    boolean player1Turn;


    public Game(boolean againstComputer, boolean player1Black) {

        //is the game against the computer? Which player is black?
        this.againstComputer = againstComputer;
        this.player1Black = player1Black;

        //set up player 1; they are always human
        player1 = new Player(player1Black, true);

        //set up player 2; can be human or AI
        player2 = new Player(!player1Black, !againstComputer);

        //create the board; first player to move is black
        currentBoard = new Board();
        player1Turn = player1Black;
    }


    void endGame(boolean player1Winner) {

    }

}