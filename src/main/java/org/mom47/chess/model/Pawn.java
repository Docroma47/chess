package org.mom47.chess.model;


public class Pawn extends ChessPiece {
    @Override
    public String toString() {
        return "Pawn [" + this.getSymbol() + this.getColor() + this.getInitialPosition().getFile() + this.getInitialPosition().getRank() + "]";
    }
}
