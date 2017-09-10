package org.mom47.chess.model;


public class ChessPiece {
    private PieceType pieceType;
    private PieceColour color;
    private String state;
    private String symbol;
    private Point position;
    private Boolean isCaptured = false;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

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

    public Point[][] getAvailablePaths() {
        return null;
    }

    @Override
    public String toString() {
        switch(getPosition().getFile()) {
            case 0:
                state = " - A" + getPosition().getRank();
                break;
            case 1:
                state = " - B" + getPosition().getRank();
                break;
            case 2:
                state = " - C" + getPosition().getRank();
                break;
            case 3:
                state = " - D" + getPosition().getRank();
                break;
            case 4:
                state = " - E" + getPosition().getRank();
                break;
            case 5:
                state = " - F" + getPosition().getRank();
                break;
            case 6:
                state = " - G" + getPosition().getRank();
                break;
            case 7:
                state = " - H" + getPosition().getRank();
                break;
        }

        if(getIsCaptured() == true) {
            state = " - captured";
        }

        return this.getSymbol() + state;
    }
}
