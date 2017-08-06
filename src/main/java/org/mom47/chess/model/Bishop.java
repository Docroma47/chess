package org.mom47.chess.model;


public class Bishop extends ChessPiece {
    private static final String WHITE_BISHOP = "♝";
    private static final String BLACK_BISHOP = "♗";

    public Bishop(PieceColour color, int file) {
        super(color);
        if(color == PieceColour.WHITE) {
            setSymbol(WHITE_BISHOP);;
            setPosition(new Point(file, 8));
        } else {
            setSymbol(BLACK_BISHOP);
            setPosition(new Point(file, 8));
        }
    }
}
