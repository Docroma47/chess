package org.mom47.chess.model;


public class Pawn extends ChessPiece {
    private static final String WHITE_PAWN = "♟";
    private static final String BLACK_PAWN = "♙";

    public Pawn(PieceColour color,int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setPosition(new Point(file, 1));
            setSymbol(WHITE_PAWN);
        } else {
            setPosition(new Point(file, 6));
            setSymbol(BLACK_PAWN);
        }
        setPieceType(PieceType.PAWN);
        getAvailablePaths()[1][1];
    }
}
