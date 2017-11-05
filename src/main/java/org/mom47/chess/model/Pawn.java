package org.mom47.chess.model;


import java.util.Arrays;

public class Pawn extends ChessPiece {
    private static final String WHITE_PAWN = "♟";
    private static final String BLACK_PAWN = "♙";
    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[1][1];
        Point position = getPosition();
        int file = position.getFile();
        int rank = position.getRank();
        if (getColor() == PieceColour.WHITE) {
            if (position.getRank() != 1) {
                free[0] = getClearPath(chessBoard, position.getUpPath(1));
                if (free[0].length != 0 && chessBoard.getPiece(free[0][0]) != null) {
                    free[0] = new Point[] { };
                }
            } else if (position.getRank() == 1) {
                free[0] = getClearPath(chessBoard, position.getUpPath(2));
                if (free[0].length != 0 && chessBoard.getPiece(free[0][0]) != null) {
                    free[0] = Arrays.copyOf(free[0], 0);
                }
                if (free[0].length != 0 && chessBoard.getPiece(free[0][1]) != null) {
                    free[0] = Arrays.copyOf(free[0], 1);
                }

            }

            if (rank + 1 <= 7 && file + 1 <= 7 && chessBoard.getPiece(new Point(file + 1, rank + 1)) != null) {
                free = Arrays.copyOf(free, free.length + 1);
                free[1] = getClearPath(chessBoard, position.getUpRightPath(1));
            }
            if (rank + 1 <= 7 && file - 1 >= 0 && chessBoard.getPiece(new Point(file - 1, rank + 1)) != null) {
                int array = free.length + 1;
                free = Arrays.copyOf(free, array);
                free[array - 1] = getClearPath(chessBoard, position.getUpLeftPath(1));
            }
        }

        if (getColor() == PieceColour.BLACK) {
            if (position.getRank() != 6) {
                free[0] = getClearPath(chessBoard, position.getDownPath(1));
                if (free[0].length != 0 && chessBoard.getPiece(free[0][0]) != null) {
                    free[0] = new Point[] { };
                }
            } else if (position.getRank() == 6) {
                free[0] = getClearPath(chessBoard, position.getDownPath(2));
                if (free[0].length != 0 && chessBoard.getPiece(free[0][0]) != null) {
                    free[0] = Arrays.copyOf(free[0], 0);
                }
                if (free[0].length != 0 && chessBoard.getPiece(free[0][1]) != null) {
                    free[0] = Arrays.copyOf(free[0], 1);
                }
            }

            if (rank - 1 >= 0 && file + 1 <= 7 && chessBoard.getPiece(new Point(file + 1, rank - 1)) != null) {
                free = Arrays.copyOf(free, free.length + 1);
                free[1] = getClearPath(chessBoard, position.getDownRightPath(1));
            }
            if (rank - 1 >= 0 && file - 1 >= 0 && chessBoard.getPiece(new Point(file - 1, rank - 1)) != null) {
                int array = free.length + 1;
                free = Arrays.copyOf(free, array);
                free[array - 1] = getClearPath(chessBoard, position.getDownLeftPath(1));
            }
        }

        return free;
    }

    public Pawn(PieceColour color,int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setPosition(new Point(file, 1));
            setSymbol(WHITE_PAWN);
        } else {
            setPosition(new Point(file, 6));
            setSymbol(BLACK_PAWN);
        }
        setPieceType(PieceType.PAWN);
    }
}
