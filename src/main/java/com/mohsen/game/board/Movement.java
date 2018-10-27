package com.mohsen.game.board;

import com.mohsen.game.piece.enumerations.PieceType;

public class Movement {
    PieceType pieceType;
    Position fromPosition;
    Position toPosition;

    public Movement(PieceType pieceType, Position fromPosition, Position toPosition) {
        this.pieceType = pieceType;
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Position getFromPosition() {
        return fromPosition;
    }

    public Position getToPosition() {
        return toPosition;
    }
}
