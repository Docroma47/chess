package org.mom47.chess.model;


public class ChessBoard {
    private ChessPiece[][] squires = new ChessPiece[8][8];


    public void setPiece(ChessPiece chessPiece) {
        int rank = chessPiece.getPosition().getRank();
        int file = chessPiece.getPosition().getFile();
        squires[file][rank] = chessPiece;
    }

    public void move(Point initial, Point destination) {
        ChessPiece chessPiece = squires[initial.getFile()][initial.getRank()];

        this.squires[initial.getFile()][initial.getRank()] = null;
        this.squires[destination.getFile()][destination.getRank()] = chessPiece;

        chessPiece.setPosition(destination);
    }
//1. Убрать с доски фигуру по координатам
//2. Засетить статус captured этой фигуре
    public void remove(Point position) {
        ChessPiece chessPiece = squires[position.getFile()][position.getRank()];
        chessPiece.setIsCaptured(true);
        squires[position.getFile()][position.getRank()] = null;

    }

    public ChessPiece getPiece(Point point) {
        return squires[point.getFile()][point.getRank()];
    }
}
