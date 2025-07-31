package org.example;

public class Main {
}

/*

Problem statement and Machine coding practice link: https://codezym.com/question/8

Chess game has different pieces like king, queen, knight etc. And each piece can have different moves like straight
move (rook), diagonal move (bishop), 2+1 move (knight) etc.

The core functionality is to check whether a piece can move to a destination row, column from its current row, column.

We use factory design pattern Chess Piece Factory to create different chess piece objects like king, queen, pawn etc.
Strategy pattern to implement different moves e.g. straight move, diagonal move etc.
Singleton pattern to ensure there is a single instance of chess piece factory object. Although this may not be a good
use case for singleton design patter, since factory instance will be used from only one place i.e. chessboard class.

 */
