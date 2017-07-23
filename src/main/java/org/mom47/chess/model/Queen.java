package org.mom47.chess.model;

public class Queen {

    private boolean color;
    private int positionX;
    private int positionY;
    private String symbol;

    private int initialPositionX;
    private int initialPositionY;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
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
        return "Queen [" + symbol + " " + positionX + ", " + positionY + "]";
    }

}
