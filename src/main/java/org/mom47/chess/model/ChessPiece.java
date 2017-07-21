package org.mom47.chess.model;


public class ChessPiece {
    private PieceColour color = PieceColour.BLACK;
    private int positionX = 01;
    private int positionY = 02 ;
    private Boolean taken = true;
    private PieceType figure = PieceType.KING;
    private String coordinatesboard = "A1";
    Point p = new Point(1, 4);

    public void setColor(PieceColour color) {
        this.color = color;
    }

    public void setPositionX(int p1) {
        this.positionX = p1;
    }

    public void setPositionY(int p2) {
        this.positionY = p2;
    }

    public void setTaken(boolean b1) {
        this.taken = b1;
    }

    public void setFigure(PieceType f1) {
        this.figure = f1;
    }

    public void setCoordinatesboard(String coordinate) {
        this.coordinatesboard = coordinate;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return  positionY;
    }

    public boolean getTaken() {
        return taken;
    }

    public PieceType getFigure() {
        return figure;
    }

    public String getCoordinatesboard() {
        return coordinatesboard;
    }

    public PieceColour getColor() {
        return color;
    }

    void move (int x, int y) {
    }
    void deleteFigure() {
    }
    void takeFigurs() {
    }
    void dontMove() {
    }
}
