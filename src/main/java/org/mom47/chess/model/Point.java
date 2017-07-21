package org.mom47.chess.model;


public class Point {
        private int rank;
        private int file;// PROBLEM!!!

        Point (int x, int y) {
                this.rank = x;
                this.file = y;
        }

        public int getFile() {
                return file;
        }

        public int getRank() {
                return rank;
        }
}
