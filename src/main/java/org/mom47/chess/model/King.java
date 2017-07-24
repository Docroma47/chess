package org.mom47.chess.model;

public class King extends ChessPiece {
    @Override
    public String toString() {
        return "King [" + this.getSymbol() + this.getColor() + this.getInitialPosition().getFile() + this.getInitialPosition().getRank() +  "]" ;
    }
}
