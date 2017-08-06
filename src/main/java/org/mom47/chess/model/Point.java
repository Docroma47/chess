package org.mom47.chess.model;


import java.util.Random;

public class Point {
    private int rank;
    private int file;
    Random random = new Random();

    public Point(int file, int rank) {
        for (int i = 0; i <=100; i++) {
            this.file = random.nextInt(file);
            this.rank = random.nextInt(rank);
        }
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
}
