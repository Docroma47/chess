package org.mom47.chess.model;


public class ChessBoard {
    private ChessPiece[][] squires = new ChessPiece[8][8];


    public void setPiece(ChessPiece chessPiece) {
        int rank = chessPiece.getPosition().getRank();
        int file = chessPiece.getPosition().getFile();
        squires[file][rank] = chessPiece;
    }

    public void move(Point initial, Point destination) {
        ChessPiece chessPiece = squires[initial.getFile()][initial.getRank()];

        this.squires[initial.getFile()][initial.getRank()] = null;
        this.squires[destination.getFile()][destination.getRank()] = chessPiece;

        chessPiece.setPosition(destination);
    }

    public void remove(Point position) {
        ChessPiece chessPiece = squires[position.getFile()][position.getRank()];
        chessPiece.setIsCaptured(true);
        squires[position.getFile()][position.getRank()] = null;
    }

    public int getFreeSquiresNumber() {
        int x = 64;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (squires[j][i] != null) {
                    x--;

                }
            }
        }
        return x;
    }

    public Point[] getFreeSquires() {
        Point[] free = new Point[getFreeSquiresNumber()];
        int x = 0;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (squires[j][i] == null) {
                    free[x] = new Point(j, i);
                    x++;
                }
            }
        }
        return free;
    }

    public ChessPiece getPiece(Point point) {
        return squires[point.getFile()][point.getRank()];
    }
}
