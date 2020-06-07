package org.mom47.chess.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ChessBoard {
    @JsonProperty
    private ChessPiece[][] square = new ChessPiece[8][8];

    @JsonIgnore
    public void setPiece(ChessPiece chessPiece) {
        int rank = chessPiece.getPosition().getRank();
        int file = chessPiece.getPosition().getFile();
        if (square[file][rank] != null) {
            throw new IllegalArgumentException("Could not set piece because the square is already " +
                    "occupied by another piece");
        }
        square[file][rank] = chessPiece;
    }

    public void move(Point initial, Point destination) {
        if (this.square[destination.getFile()][destination.getRank()] != null) {
            throw new IllegalArgumentException("Could not set piece because the square is already " +
                    "occupied by another piece");
        }

        ChessPiece chessPiece = square[initial.getFile()][initial.getRank()];

        this.square[initial.getFile()][initial.getRank()] = null;
        this.square[destination.getFile()][destination.getRank()] = chessPiece;

        chessPiece.setPosition(destination);
    }

    @JsonIgnore
    public void remove(Point position) {
        ChessPiece chessPiece = square[position.getFile()][position.getRank()];
        chessPiece.setIsCaptured(true);
        square[position.getFile()][position.getRank()] = null;
    }

    @JsonIgnore
    public int getFreeSquaresNumber() {
        int x = 64;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (square[j][i] != null) {
                    x--;
                }
            }
        }
        return x;
    }

    @JsonIgnore
    public Point[] getFreeSquares() {
        Point[] free = new Point[getFreeSquaresNumber()];
        int x = 0;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (square[j][i] == null) {
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
                if (square[j][i] == null) {
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
                if (square[j][i] != null) {
                    figuresBoard[x] = getPiece(new Point(j, i));
                    x++;
                }
            }
        }
        return figuresBoard;
    }

    @JsonIgnore
    public ChessPiece getPiece(Point point) {
        return square[point.getFile()][point.getRank()];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoard that = (ChessBoard) o;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (square[i][j] != that.square[i][j]) {
                    if (!square[i][j].equals(that.square[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(square);
    }
}
