package org.mom47.chess.model;


public class Pawn extends ChessPiece {
    @Override
    public String toString() {
        return "Pawn [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }

    public Pawn(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
}
