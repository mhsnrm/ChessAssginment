package com.mohsen.game.board;

import com.mohsen.game.InvalidMovementException;
import com.mohsen.game.piece.Piece;
import com.mohsen.game.piece.enumerations.PieceColor;
import com.mohsen.game.piece.enumerations.PieceType;

public class MovementManager {

    private GameBoard gameBoard = GameBoard.getGameBoard();

    public Position manageMovement(int fromX, int fromY, int toX, int toY) throws InvalidMovementException {
        Position fromPosition = new Position(fromX, fromY);
        Position toPosition = new Position(toX, toY);
        Position currentPositionData = GameBoard.getGameBoard().getPositions()[fromX][fromY];
        Piece piece = currentPositionData.getPiece();
        if (isChecked(piece.getColor()))
            System.out.println(piece.getColor() + "is checked.");
        if (!piece.isMovementValid(fromPosition, toPosition)) {
            throw new InvalidMovementException();
        }
        Position nextPosition = GameBoard.getGameBoard().getPositions()[toX][toY];
        Piece tmpPiece = nextPosition.getPiece();
        if (!nextPosition.isEmpty()) {
            Piece nextPositionPiece = nextPosition.getPiece();
            if (nextPositionPiece.getColor() == piece.getColor()) {
                throw new InvalidMovementException();
            }
        }
        if (piece.getType().equals(PieceType.KING)) {
            GameBoard.getGameBoard().updateKingPosition(fromPosition);
        }
        GameBoard.getGameBoard().move(fromPosition, toPosition);
        if (isChecked(piece.getColor())){
            GameBoard.getGameBoard().move(toPosition, fromPosition);
            GameBoard.getGameBoard().getPosition(fromPosition.getX(), fromPosition.getY()).setPiece(tmpPiece);
            throw new InvalidMovementException();
        }
        return nextPosition;
    }

    private boolean isChecked(PieceColor kingPieceColor) {
        return isThereAnyPawnAround(kingPieceColor) || isThereAnyKnightAround(kingPieceColor) ||
        isVisibleToAnyRock(kingPieceColor) || isVisibleToAnyBishop(kingPieceColor) || isVisibleToQueen(kingPieceColor);
    }

    private boolean isThereAnyPawnAround(PieceColor kingColor) {
        Position kingPosition;
        if (kingColor.equals(PieceColor.WHITE)) {
            kingPosition = gameBoard.getWhiteKingPosition();
        } else {
            kingPosition = gameBoard.getBlackKingPosition();
        }

        if (gameBoard.getPosition(kingPosition.getX() + 1, kingPosition.getY()).isEmpty() &&
                gameBoard.getPosition(kingPosition.getX() - 1, kingPosition.getY()).isEmpty())
            return false;

        if (gameBoard.getPosition(kingPosition.getX() + 1, kingPosition.getY()).getPiece().getColor().equals(kingColor) &&
                gameBoard.getPosition(kingPosition.getX() - 1, kingPosition.getY()).getPiece().getColor().equals(kingColor))
            return false;

        return true;
    }

    private boolean isThereAnyKnightAround(PieceColor kingColor) {
        Position kingPosition;
        if (kingColor.equals(PieceColor.WHITE)) {
            kingPosition = gameBoard.getWhiteKingPosition();
        } else {
            kingPosition = gameBoard.getBlackKingPosition();
        }
        int kingX = kingPosition.getX();
        int kingY = kingPosition.getY();


        if (kingX + 1 <= 7 && kingY + 2 <= 7) {
            Position position = gameBoard.getPosition(kingX + 1, kingY + 2);
            if (isKnightAround(position, kingColor))
                return true;
        }

        if (kingX + 1 <= 7 && kingY - 2 >= 0) {
            Position position = gameBoard.getPosition(kingX + 1, kingY - 2);
            if (isKnightAround(position, kingColor))
                return true;

        }

        if (kingX - 1 >= 0 && kingY + 2 <= 7) {
            Position position = gameBoard.getPosition(kingX - 1, kingY + 2);
            if (isKnightAround(position, kingColor))
                return true;

        }

        if (kingX - 1 >= 0 && kingY - 2 >= 0) {
            Position position = gameBoard.getPosition(kingX - 1, kingY - 2);
            if (isKnightAround(position, kingColor))
                return true;

        }

        if (kingX + 2 <= 7 && kingY + 1 <= 7) {
            Position position = gameBoard.getPosition(kingX + 2, kingY + 1);
            if (isKnightAround(position, kingColor))
                return true;
        }

        if (kingX + 2 <= 7 && kingY - 1 >= 0) {
            Position position = gameBoard.getPosition(kingX + 2, kingY - 1);
            if (isKnightAround(position, kingColor))
                return true;
        }

        if (kingX - 2 >= 0 && kingY + 1 <= 7) {
            Position position = gameBoard.getPosition(kingX - 2, kingY + 1);
            if (isKnightAround(position, kingColor))
                return true;
        }

        if (kingX - 2 >= 0 && kingY - 1 >= 0) {
            Position position = gameBoard.getPosition(kingX - 2, kingY + 1);
            if (isKnightAround(position, kingColor))
                return true;
        }
        return false;
    }

    private boolean isKnightAround(Position position, PieceColor kingColor) {
        return (!position.isEmpty() && !position.getPiece().getColor().equals(kingColor) && position.getPiece().equals(PieceType.KNIGHT));
    }

    private boolean isVisibleToAnyRock(PieceColor kingColor) {
        Position kingPosition;
        if (kingColor.equals(PieceColor.WHITE)) {
            kingPosition = gameBoard.getWhiteKingPosition();
        } else {
            kingPosition = gameBoard.getBlackKingPosition();
        }
        int kingX = kingPosition.getX();
        int kingY = kingPosition.getY();

        Position[][]positions = gameBoard.getPositions();

        for (int i = 0; i < 8; i++) {
            Position position = positions[kingX][i];
            if(isAnyRockAround(position, kingColor))
                return true;

            position = positions[i][kingY];
            if (isAnyRockAround(position, kingColor))
                return true;
        }
        return false;
    }
    private boolean isAnyRockAround(Position position, PieceColor kingColor){
        return (!position.isEmpty() && !position.getPiece().getColor().equals(kingColor) && position.getPiece().getType().equals(PieceType.ROCK));
    }

    private boolean isVisibleToAnyBishop(PieceColor kingColor) {
        Position kingPosition;
        if (kingColor.equals(PieceColor.WHITE)) {
            kingPosition = gameBoard.getWhiteKingPosition();
        } else {
            kingPosition = gameBoard.getBlackKingPosition();
        }
        int kingX = kingPosition.getX();
        int kingY = kingPosition.getY();

        int x = kingX;
        int y = kingY;
        while (x <= 7 && y<=7){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyBishopAround(position, kingColor))
                return true;
            x++;
            y++;
        }

        x = kingX;
        y = kingY;
        while (x >= 0 && y>=0){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyBishopAround(position, kingColor))
                return true;
            x--;
            y--;
        }

        x = kingX;
        y = kingY;
        while (x <= 7 && y>=0){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyBishopAround(position, kingColor))
                return true;
            x++;
            y--;
        }

        x = kingX;
        y = kingY;
        while (x >= 0 && y<=7){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyBishopAround(position, kingColor))
                return true;
            x--;
            y++;
        }
        return false;

    }

    private boolean isAnyBishopAround(Position position, PieceColor kingColor){
        return (!position.isEmpty() && !position.getPiece().getColor().equals(kingColor) && position.getPiece().getType().equals(PieceType.BISHOP));
    }

    private boolean isVisibleToQueen(PieceColor kingColor) {
        Position kingPosition;
        if (kingColor.equals(PieceColor.WHITE)) {
            kingPosition = gameBoard.getWhiteKingPosition();
        } else {
            kingPosition = gameBoard.getBlackKingPosition();
        }
        int kingX = kingPosition.getX();
        int kingY = kingPosition.getY();

        Position[][]positions = gameBoard.getPositions();

        for (int i = 0; i < 8; i++) {
            Position position = positions[kingX][i];
            if(isAnyQueenAround(position, kingColor))
                return true;

            position = positions[i][kingY];
            if (isAnyRockAround(position, kingColor))
                return true;
        }

        int x = kingX;
        int y = kingY;
        while (x <= 7 && y<=7){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyQueenAround(position, kingColor))
                return true;
            x++;
            y++;
        }

        x = kingX;
        y = kingY;
        while (x >= 0 && y>=0){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyQueenAround(position, kingColor))
                return true;
            x--;
            y--;
        }

        x = kingX;
        y = kingY;
        while (x <= 7 && y>=0){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyQueenAround(position, kingColor))
                return true;
            x++;
            y--;
        }

        x = kingX;
        y = kingY;
        while (x >= 0 && y<=7){
            Position position = gameBoard.getPosition(x, y);
            if (isAnyQueenAround(position, kingColor))
                return true;
            x--;
            y++;
        }
        return false;
    }

    private boolean isAnyQueenAround(Position position, PieceColor kingColor){
        return (!position.isEmpty() && !position.getPiece().getColor().equals(kingColor) && position.getPiece().getType().equals(PieceType.QUEEN));
    }
}
