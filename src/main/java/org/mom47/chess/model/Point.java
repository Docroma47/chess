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

    public Point getUp() {
        return new Point(file, rank + 1);
    }

    public Point getUpRight() {
        return new Point(file + 1, rank + 1);
    }

    public Point getRight() {
        return new Point(file + 1, rank);
    }

    public Point getDownRight() {
        return new Point(file + 1, rank - 1);
    }

    public Point getDown() {
        return new Point(file, rank - 1);
    }

    public Point getDownLeft() {
        return new Point(file - 1, rank - 1);
    }

    public Point getLeft() {
        return new Point(file - 1, rank);
    }

    public Point getUpLeft() {
        return new Point(file - 1, rank + 1);
    }

    public Point getUpLeftHorse() {
        return new Point(file - 1, rank + 2);
    }

    public Point getUpRightHorse() {
        return new Point(file + 1, rank + 2);
    }

    public Point getRightUpHorse() {
        return new Point(file + 2, rank + 1);
    }

    public Point getRightDownHorse() {
        return new Point(file + 2, rank - 1);
    }

    public Point getDownRightHorse() {
        return new Point(file + 1, rank - 2);
    }

    public Point getDownLeftHorse() {
        return new Point(file - 1, rank - 2);
    }

    public Point getLeftUpHorse() {
        return new Point(file - 2, rank + 1);
    }

    public Point getLeftDownHorse() {
        return new Point(file - 2, rank - 1);
    }

    public Point[] getUpPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, 7 - rank);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file, rank + i + 1);
        }

        return path;
    }

    public Point[] getRightPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, 7 - file);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + i + 1, rank);
        }

        return path;
    }

    public Point[] getLeftPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, file);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - i - 1, rank);
        }

        return path;
    }

    public Point[] getDownPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, rank);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file, rank - i - 1);
        }

        return path;
    }

    public Point[] getUpLeftPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int x = file;
        int y = rank;
        int max = Math.min(x, 7 - y);
        int size = Math.min(count, max);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - i - 1, rank + i + 1);
        }

        return path;
    }

    public Point[] getUpRightPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int x = file;
        int y = rank;
        int max = Math.max(x, y);
        int size = Math.min(count, 7 - max);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + i + 1, rank + i + 1);
        }

        return path;
    }

    public Point[] getDownLeftPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int x = file;
        int y = rank;
        int max = Math.min(x, y);
        int size = Math.min(count, max);
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - i - 1, rank - i - 1);
        }

        return path;
    }

    public Point[] getDownRightPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int x = file;
        int y = rank;
        int max = Math.min(7 - x, y);
        int size = Math.min(count, max );
        Point[] path = new Point[size];
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + i + 1, rank - i - 1);
        }

        return path;
    }

    public Point[] getDownRightHorsePath(int count) {
        Point[] path = new Point[count];
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int x = 7 - file;
        int y = 7 - rank;
        int max = Math.min(x, y);
        int size = Math.min(count, max );
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + i + 1, rank - i - 1);
        }

        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (rank != point.rank) return false;
        return file == point.file;
    }

    @Override
    public String toString() {
        return "File: " + file + " Rank: " + rank;
    }
}
