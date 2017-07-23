package org.mom47.chess.model;

public class King {

    private PieceColour color;
    private Point position;

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

    @Override
    public String toString() {
        return "King [" + color + ", (" + position.getFile() + ", " + position.getRank() + ")]";
    }
}
