package org.mom47.chess.model;


public class Rook extends ChessPiece {
    private static final String WHITE_ROOK = "♜";
    private static final String BLACK_ROOK = "♖";

    public Rook(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_ROOK);
            setPosition(new Point(file, 1));
        } else {
            setSymbol(BLACK_ROOK);
            setPosition(new Point(file, 8));
        }
    }
}
