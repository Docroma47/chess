package org.mom47.chess.model;


public class Queen extends ChessPiece {
    @Override
    public String toString() {
        return "Queen [" + this.getSymbol() + ", " + this.getPosition() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }

    public Queen(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
}
