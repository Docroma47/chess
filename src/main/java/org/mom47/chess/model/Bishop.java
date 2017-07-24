package org.mom47.chess.model;


public class Bishop extends ChessPiece {
    public Bishop(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
    @Override
    public String toString() {
        return "Bishop [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
