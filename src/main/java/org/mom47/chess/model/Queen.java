package org.mom47.chess.model;

public class Queen {

    private boolean color;
    private Point position;
    private String symbol;

    private int initialPositionX;
    private int initialPositionY;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getInitialPositionX() {
        return initialPositionX;
    }

    public void setInitialPositionX(int initialPositionX) {
        this.initialPositionX = initialPositionX;
    }

    public int getInitialPositionY() {
        return initialPositionY;
    }

    public void setInitialPositionY(int initialPositionY) {
        this.initialPositionY = initialPositionY;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Queen [" + symbol + " " + position.getFile() + ", " + position.getRank() + "]";
    }

}
