package org.mom47.chess.model;


public class Bishop extends ChessPiece {
    @Override
    public String toString() {
        return "Bishop [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }
}
