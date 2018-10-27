package com.mohsen.game.board;

import com.mohsen.game.piece.Piece;

public class Position {
    private Piece piece;
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEmpty(){
        return piece == null;
    }

    @Override
    public String toString() {
        return "Position{" +
                "piece=" + piece +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
