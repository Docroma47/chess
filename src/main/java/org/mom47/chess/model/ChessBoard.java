package org.mom47.chess.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChessBoard {
    @JsonProperty
    private ChessPiece[][] squires = new ChessPiece[8][8];

    @JsonIgnore
    public void setPiece(ChessPiece chessPiece) {
        int rank = chessPiece.getPosition().getRank();
        int file = chessPiece.getPosition().getFile();
        if (squires[file][rank] != null) {
            throw new IllegalArgumentException("Could not set piece because the squire is already " +
                    "occupied by another piece");
        }
        squires[file][rank] = chessPiece;
    }

    public void move(Point initial, Point destination) {
        if (this.squires[destination.getFile()][destination.getRank()] != null) {
            throw new IllegalArgumentException("Could not set piece because the squire is already " +
                    "occupied by another piece");
        }

        ChessPiece chessPiece = squires[initial.getFile()][initial.getRank()];

        this.squires[initial.getFile()][initial.getRank()] = null;
        this.squires[destination.getFile()][destination.getRank()] = chessPiece;

        chessPiece.setPosition(destination);
    }

    @JsonIgnore
    public void remove(Point position) {
        ChessPiece chessPiece = squires[position.getFile()][position.getRank()];
        chessPiece.setIsCaptured(true);
        squires[position.getFile()][position.getRank()] = null;
    }

    @JsonIgnore
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

    @JsonIgnore
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

    @JsonIgnore
    public int getChessPiecesNumber() {
        int x = 64;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (squires[j][i] == null) {
                    x--;
                }
            }
        }
        return x;
    }

    @JsonIgnore
    public ChessPiece[] getChessPieces() {
        ChessPiece[] figuresBoard = new ChessPiece[getChessPiecesNumber()];
        int x = 0;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (squires[j][i] != null) {
                    figuresBoard[x] = getPiece(new Point(j, i));
                    x++;
                }
            }
        }
        return figuresBoard;
    }

    @JsonIgnore
    public ChessPiece getPiece(Point point) {
        return squires[point.getFile()][point.getRank()];
    }

}
