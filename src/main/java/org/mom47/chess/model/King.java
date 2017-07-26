package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♔";
    private static final String BLACK_KING = "♚";

    public King(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_KING);
            setPosition(new Point(file, 8));
        } else {
            setSymbol(BLACK_KING);;
            setPosition(new Point(file, 1));
        }
    }

    @Override
    public String toString() {
        return "King [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
