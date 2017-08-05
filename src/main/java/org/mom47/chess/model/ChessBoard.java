package org.mom47.chess.model;


public class ChessBoard {
    private ChessPiece[][] squires = new ChessPiece[9][9];


    public void setPiece(ChessPiece chessPiece) {
        int rank = chessPiece.getPosition().getRank();
        int file = chessPiece.getPosition().getFile();
        squires[file][rank] = chessPiece;
    }

    public ChessPiece getPiece(Point point) {
        return squires[point.getFile()][point.getRank()];
    }
}
