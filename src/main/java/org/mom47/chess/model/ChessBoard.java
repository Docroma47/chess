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

    public ChessPiece getPiece(Point point) {
        return squires[point.getFile()][point.getRank()];
    }
}
