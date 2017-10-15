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
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file, rank + j);
            j++;
        }

        return path;
    }

    public Point[] getRightPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, 7 - file);
        Point[] path = new Point[size];
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + j, rank);
            j++;
        }

        return path;
    }

    public Point[] getLeftPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, file);
        Point[] path = new Point[size];
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - j, rank);
            j++;
        }

        return path;
    }

    public Point[] getDownPath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        int size = Math.min(count, rank);
        Point[] path = new Point[size];
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file, rank - j);
            j++;
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
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - j, rank + j);
            j++;
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
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + j, rank + j);
            j++;
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
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file - j, rank - j);
            j++;
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
        int j = 1;
        for (int i = 0; i <= size - 1; i++) {
            path[i] = new Point(file + j, rank - j);
            j++;
        }

        return path;
    }

    public Point[] getDownRightHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file + i + 1, rank - i - 2);
            if (path[i].rank < 0 || path[i].file > 7) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getDownLeftHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file - i - 1, rank - i - 2);
            if (path[i].rank < 0 || path[i].file < 0) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getUpRightHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file + i + 1, rank + i + 2);
            if (path[i].rank > 7 || path[i].file > 7) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getUpLeftHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file - i - 1, rank + i + 2);
            if (path[i].rank > 7 || path[i].file < 0) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getLeftUpHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file - i - 2, rank + i + 1);
            if (path[i].rank > 7 || path[i].file < 0) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getLeftDownHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file - i - 2, rank - i - 1);
            if (path[i].rank < 0 || path[i].file < 0) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getRightUpHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file + i + 2, rank + i + 1);
            if (path[i].rank > 7 || path[i].file > 7) {
                path = new Point[]{ };
                return path;
            }
        }

        return path;
    }

    public Point[] getRightDownHorsePath(int count) {
        Point point = new Point(file, rank);
        int rank = point.rank;
        int file = point.file;
        Point[] path = new Point[count];
        for (int i = 0; i <= count - 1; i++) {
            path[i] = new Point(file + i + 2, rank - i - 1);
            if (path[i].rank < 0 || path[i].file > 7) {
                path = new Point[]{ };
                return path;
            }
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
