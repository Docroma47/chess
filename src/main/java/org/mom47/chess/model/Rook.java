package org.mom47.chess.model;


public class Rook extends ChessPiece {
    private static final String WHITE_ROOK = "♖";
    private static final String BLACK_ROOK = "♜";

    public Rook(PieceColour color, int file) {
        super(color);
        if (color==PieceColour.WHITE) {
            setSymbol(WHITE_ROOK);
            setPosition(new Point(file, 1));
        } else {
            setSymbol(BLACK_ROOK);
            setPosition(new Point(file, 8));
        }
    }

    @Override
    public String toString() {
        return "Rook [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
