package org.example.models;

public class Board {
    Integer XCount;
    Integer OCount ;
    int[][] boardMatrix;

    public Board() {
        this.XCount = 5;
        this.OCount = 4;
        this.boardMatrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    Boolean setPiece (int i, int j, PieceType pieceType) {
        this.validate(i, j);

    }

    Boolean validate (int i, int j) {
        if (this.boardMatrix[i][j] != 0) {
            return false;
        }
        // add more validations
        return true;
    }
}
