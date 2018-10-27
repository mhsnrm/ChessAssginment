package com.mohsen.game.piece.enumerations;

public enum PieceType {
    PAWN(1),
    ROCK(2),
    KNIGHT(3),
    BISHOP(4),
    QUEEN(5),
    KING(6);

    private int index;

    PieceType(int index) {
        this.index = index;
    }

    public static PieceType getPieceTypeBy(int index) {
        for (PieceType l : PieceType.values()) {
            if (l.index == index) return l;
        }
        throw new IllegalArgumentException("Leg not found. Amputated?");
    }
}
