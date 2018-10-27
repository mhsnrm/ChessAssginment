package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class King extends Piece {

    public King(PieceColor color) {
        super(color, PieceType.KING);
    }

    @Override
    public boolean isMovementValid(Position fromPosition, Position toPosition) {
        if (!movementCommonValidation(fromPosition, toPosition))
            return false;

        if (Math.sqrt(Math.pow(Math.abs((toPosition.getX() - fromPosition.getX())), 2)) +
                Math.pow(Math.abs((toPosition.getY() - fromPosition.getY())), 2) != Math.sqrt(2)) {
            return false;
        }
        return true;
    }
}
