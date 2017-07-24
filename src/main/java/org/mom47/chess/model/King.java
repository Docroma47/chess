package org.mom47.chess.model;


public class King extends ChessPiece {
    public King(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
    @Override
    public String toString() {
        return "King [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
