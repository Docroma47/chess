package org.mom47.chess.model;


import java.util.Random;

public class Point {
    private int rank;
    private int file;

    public Point(int file, int rank) {
        Random random = new Random();
        file = 7;
        rank = 7;
        this.file = random.nextInt(file);
        this.rank = random.nextInt(rank);
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
}
