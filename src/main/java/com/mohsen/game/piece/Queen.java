package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
    }

    @Override
    public boolean isMovementValid(Position fromPosition, Position toPosition) {
        if (!movementCommonValidation(fromPosition, toPosition))
            return false;

        if (toPosition.getX() == fromPosition.getX() || toPosition.getY() == fromPosition.getY() ||
                toPosition.getX() - fromPosition.getX() == toPosition.getY() - fromPosition.getY())
            return true;

        return false;
    }
}
