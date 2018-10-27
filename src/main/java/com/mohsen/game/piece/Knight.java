package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
    }

    @Override
    public boolean isMovementValid(Position fromPosition, Position toPosition) {
        if (!movementCommonValidation(fromPosition, toPosition))
            return false;

        if (toPosition.getX() != fromPosition.getX() - 1 && toPosition.getX() != fromPosition.getX() + 1 &&
                toPosition.getX() != fromPosition.getX() + 2 && toPosition.getX() != fromPosition.getX() - 2)
            return false;
        if (toPosition.getY() != fromPosition.getY() - 2 && toPosition.getY() != fromPosition.getY() + 2
                && toPosition.getY() != fromPosition.getY() - 1 && toPosition.getY() != fromPosition.getY() + 1)
            return false;

        return true;
    }
}

