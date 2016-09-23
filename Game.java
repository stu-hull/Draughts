package com.example.stuart.draughts;

// ANNOTATION TERMINOLOGY:
// Mover- a piece which can slide into an adjacent square
// Jumper- a piece which can jump an enemy piece into the square beyond
// LF, RF, LB, RB - Left-forward, right-forward, right-backward, left-backward (from Black's perspective)
// Bitboard- a Long number, 45 bits used to represent some boolean property of every square of a game board, eg, all of the squares with white pieces on
// Mask- like a bitboard, but representing a boolean property universal to all boards, eg, the 32 out of 45 bits which represent valid board locations

// 'currentBoard' refers ONLY to the current gamestate being displayed to the player. For all other hypothetical boards please use 'board'

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
    }

    Player player1;
    Player player2;

    Board currentBoard; //current board being displayed
    Board newBoard; //board after move requested by player

    //boolean variables for details of the game
    boolean againstComputer; //is it against AI or 2 player
    boolean player1Black; //is player 1 black
    boolean player1Turn; //is it player 1's turn
    boolean inPlay; //is the game playing? (has a winner been found?)
    boolean player1win; //has player 1 won?

    //constructor sets up initial details of the game and displays them
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

        //shows start pieces on board
        displayMove();
    }

    //runs the game overall, making players move and deciding when the game has ended
    //does not start the game on button press, startGame() in MainMenu.java does this
    //does not end the game, this is managed by endGame() in this class
    public void runGame(){
        while (inPlay) {
            if (player1Turn){
                newBoard = player1.makeMove(currentBoard);
            } else {
                newBoard = player2.makeMove(currentBoard);
            }
            if (newBoard.isNull()){
                inPlay = false;
                player1win = !player1Turn;
                endGame();
            }
            displayMove();
            player1Turn = !player1Turn;
        }
    }

    //uses currentBoard and newBoard to animate a move taking place.
    public void displayMove(){
        //animation
        currentBoard = newBoard;
    }


    void endGame() {

    }

}