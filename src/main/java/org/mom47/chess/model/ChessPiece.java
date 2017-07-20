package org.mom47.chess.model;


public class ChessPiece {
    private int color = 0;
    private int positionX = 01;
    private int positionY = 02 ;
    private Boolean taken = true;
    private String figure = "King";
    private String coordinatesboard = "A1";


    public void setColor(int color) {
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

    public void setFigure(String namefigure) {
        this.figure = namefigure;
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

    public String getFigure() {
        return figure;
    }

    public String getCoordinatesboard() {
        return coordinatesboard;
    }

    public int getColur() {
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
class Point{
    private int rank;
    private int file;

}
