package org.mom47.chess.model;


public class ChessPiece {
    private PieceColour color;
    private String symbol;
    private Point position;
    private Boolean isCaptured = false;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setColor(PieceColour color) {
        this.color = color;
    }

    public PieceColour getColor() {
        return color;
    }

    public ChessPiece(PieceColour color) {
        setColor(color);
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public Boolean getIsCaptured() {
        return isCaptured;
    }
}
