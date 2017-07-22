package org.mom47.chess.model;


public class Point {

    private int rank;
    private int file;

    public Point(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
}
