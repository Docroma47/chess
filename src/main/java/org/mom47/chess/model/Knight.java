package org.mom47.chess.model;


public class Knight extends ChessPiece {
    @Override
    public String toString() {
        return "Knight [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }

    public Knight(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
}
