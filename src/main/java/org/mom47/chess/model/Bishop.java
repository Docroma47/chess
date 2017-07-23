package org.mom47.chess.model;


public class Bishop {
    private PieceColour color;
    private Point position;
    private String symbol;

    private Point initialPosition;

    public PieceColour isColor() {
        return color;
    }

    public void setColor(PieceColour color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Point initialPosition) {
        this.initialPosition = initialPosition;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Bishop [" + symbol + " " + color + ", (" + position.getFile() + ", " + position.getRank() + ")]";
    }
}
