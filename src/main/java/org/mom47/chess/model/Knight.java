package org.mom47.chess.model;


public class Knight extends ChessPiece {
    @Override
    public String toString() {
        return "Knight [" + this.getSymbol() + this.getColor() + this.getInitialPosition().getFile() + this.getInitialPosition().getRank() + "]";
    }
}
