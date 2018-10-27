package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public abstract class Piece {
    private PieceColor color;
    private PieceType type;
    private boolean isAlive = true;

    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public PieceType getType() {
        return type;
    }

    static boolean movementCommonValidation(Position fromPosition, Position toPosition) {
        if (toPosition.getX() == fromPosition.getX() && fromPosition.getY() == toPosition.getY())
            return false;
        if (toPosition.getX() < 0 || toPosition.getX() > 7 || fromPosition.getX() < 0 || fromPosition.getX() > 7 ||
                toPosition.getY() < 0 || toPosition.getY() > 7 || fromPosition.getY() < 0 || fromPosition.getY() > 7)
            return false;
        return true;
    }

    public abstract boolean isMovementValid(Position fromPosition, Position toPosition);

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", type=" + type +
                ", isAlive=" + isAlive +
                '}';
    }
}
