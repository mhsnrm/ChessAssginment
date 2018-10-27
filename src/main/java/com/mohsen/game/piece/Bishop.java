package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
    }

    @Override
    public boolean isMovementValid(Position fromPosition, Position toPosition) {
        if (!movementCommonValidation(fromPosition, toPosition))
            return false;

        if (toPosition.getX() - fromPosition.getX() == toPosition.getY() - fromPosition.getY())
            return true;

        return false;
    }
}

