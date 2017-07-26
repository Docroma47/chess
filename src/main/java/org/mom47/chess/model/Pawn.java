package org.mom47.chess.model;


public class Pawn extends ChessPiece {
    private static final String WHITE_PAWN = "♙";
    private static final String BLACK_PAWN = "♟";

    public Pawn(PieceColour color,int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setPosition(new Point(file, 7));
            setSymbol(WHITE_PAWN);
        } else {
            setPosition(new Point(file, 2));
            setSymbol(BLACK_PAWN);
        }
    }

    @Override
    public String toString() {
        return "Pawn [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
