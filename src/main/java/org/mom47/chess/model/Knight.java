package org.mom47.chess.model;


public class Knight extends ChessPiece {
    private static final String WHITE_KNIGHT = "♘";
    private static final String BLACK_KNIGHT = "♞";

    public Knight(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_KNIGHT);
            setPosition(new Point(file, 8));
        } else {
            setSymbol(BLACK_KNIGHT);
            setPosition(new Point(file, 1));
        }
    }

    @Override
    public String toString() {
        return "Knight [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
