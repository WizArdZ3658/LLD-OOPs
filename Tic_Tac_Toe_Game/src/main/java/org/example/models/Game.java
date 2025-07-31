package org.example.models;

public class Game {
    Board board ;
    User player1;
    User player2;
    Boolean player1Turn;

    Public Game (Board board, User player1, User player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.player1Turn = true;
    }

    Public player1Move(int i, int j) {
        If (this.player1Turn) {
            Bool possible = this.board.setPiece(i, j, PieceType.X);
            If (possible) {
                // return positive
            } else {
// return negative
            }
        } else {
            // return negative
        }
    }

    Public player2Move(int i, int j) {

    }
}
