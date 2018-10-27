package com.mohsen.game.board;

import com.mohsen.game.piece.*;
import com.mohsen.game.piece.enumerations.PieceColor;

public class GameBoard {

    private Position[][]positions = new Position[8][8];
    private Position blackKingPosition;
    private Position whiteKingPosition;

    private static GameBoard gameBoard = new GameBoard();

    public static GameBoard getGameBoard() {
        return gameBoard;
    }

    private GameBoard() {
        for(int i=0; i<positions.length; i++){
            for(int j=0; j<positions.length; j++){
                this.positions[i][j] = new Position(i, j);
            }
        }
        initGameBoard();
    }

    private void initGameBoard(){
        for (int i = 0; i<8; i++){
            positions[i][1] = new Position(new Pawn(PieceColor.WHITE),i, 1);
            positions[i][6] = new Position(new Pawn(PieceColor.BLACK),i, 6);
        }
        positions[0][0] = new Position(new Rock(PieceColor.WHITE),0, 0);
        positions[7][0] = new Position(new Rock(PieceColor.WHITE),7, 0);
        positions[1][0] = new Position(new Knight(PieceColor.WHITE),1, 0);
        positions[6][0] = new Position(new Knight(PieceColor.WHITE),6, 0);
        positions[2][0] = new Position(new Bishop(PieceColor.WHITE),2, 0);
        positions[5][0] = new Position(new Bishop(PieceColor.WHITE),5, 0);
        positions[3][0] = new Position(new Queen(PieceColor.WHITE),3, 0);
        whiteKingPosition = new Position(new King(PieceColor.WHITE),4, 0);
        positions[4][0]= whiteKingPosition;

        positions[0][7] = new Position(new Rock(PieceColor.BLACK),0, 7);
        positions[7][7] = new Position(new Rock(PieceColor.BLACK),7, 7);
        positions[1][7] = new Position(new Knight(PieceColor.BLACK),1, 7);
        positions[6][7] = new Position(new Knight(PieceColor.BLACK),6, 7);
        positions[2][7] = new Position(new Bishop(PieceColor.BLACK),2, 7);
        positions[5][7] = new Position(new Bishop(PieceColor.BLACK),5, 7);
        positions[3][7] = new Position(new Queen(PieceColor.BLACK),3, 7);
        blackKingPosition = new Position(new King(PieceColor.BLACK),4, 7);
        positions[4][7] = blackKingPosition;
    }

    public void move(Position fromPosition, Position toPosition){
        positions[toPosition.getX()][toPosition.getY()] = new Position(fromPosition.getPiece(), toPosition.getX(), toPosition.getY());
    }

    public Position[][] getPositions() {
        return positions;
    }

    public Position getPosition(int x, int y){
        return positions[x][y];
    }

    public void updateKingPosition(Position position){
        if (position.getPiece().getColor().equals(PieceColor.WHITE)){
            whiteKingPosition = position;
        } else {
            blackKingPosition = position;
        }
    }

    public Position getBlackKingPosition() {
        return blackKingPosition;
    }

    public Position getWhiteKingPosition() {
        return whiteKingPosition;
    }
}
