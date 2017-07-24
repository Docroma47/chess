package org.mom47.chess.model;

public class Queen extends ChessPiece {
    @Override
    public String toString() {
        return "Queen [" + this.getSymbol() + this.getColor() + this.getInitialPosition().getFile() + this.getInitialPosition().getRank() +  "]";
    }

}
