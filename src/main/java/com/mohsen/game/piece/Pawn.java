package com.mohsen.game.piece;

import com.mohsen.game.board.Position;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
    }

    @Override
    public boolean isMovementValid(Position fromPosition, Position toPosition) {
        if (!movementCommonValidation(fromPosition, toPosition))
            return false;



        //todo
        return true;
    }
}
