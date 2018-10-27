package com.mohsen.game.player;

import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class Player {
    private PieceColor pieceColor;
    private boolean isTurn;
    private int queenCount;
    private int bishopCount;
    private int knightCount;
    private int rockCount;
    private int pawnCount;

    {
        queenCount = 1;
        bishopCount = 2;
        knightCount = 2;
        rockCount = 2;
        pawnCount = 8;
    }

    public Player(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void minusPiece(PieceType pieceType){
        switch (pieceType){
            case PAWN:
                pawnCount = pawnCount -1;
                break;
            case ROCK:
                rockCount = rockCount -1;
                break;
            case KNIGHT:
                knightCount = knightCount-1;
                break;
            case BISHOP:
                bishopCount=bishopCount-1;
                break;
            case QUEEN:
                queenCount = queenCount-1;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
