package org.mom47.chess.model;



public class Pawn extends ChessPiece {
    private static final String WHITE_PAWN = "♟";
    private static final String BLACK_PAWN = "♙";
    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[3][1];
        Point position = getPosition();
        if (getColor() == PieceColour.WHITE) {
            if (position.getRank() != 1) {
                free[0] = getClearPath(chessBoard, position.getUpPath(1));
            } else if (position.getRank() == 1) {
                free[0] = getClearPath(chessBoard, position.getUpPath(2));
            }
            free[1] = getClearPath(chessBoard, position.getUpRightPath(1));
            free[2] = getClearPath(chessBoard, position.getUpLeftPath(1));
            if (free[0].length != 0 && chessBoard.getPiece(free[0][0]) != null) {
                free[0] = new Point[] { };
            }
        }

        if (getColor() == PieceColour.BLACK) {
            if (position.getRank() != 6) {
                free[0] = getClearPath(chessBoard, position.getDownPath(1));
            } else if (position.getRank() == 6) {
                free[0] = getClearPath(chessBoard, position.getDownPath(2));
            }
            free[1] = getClearPath(chessBoard, position.getDownRightPath(1));
            free[2] = getClearPath(chessBoard, position.getDownLeftPath(1));
        }

        if (free[1].length != 0 && chessBoard.getPiece(free[1][0]) == null || free[2].length != 0 && chessBoard.getPiece(free[2][0]) == null) {
            if (free[1].length != 0 && chessBoard.getPiece(free[1][0]) == null) {
                free[1] = new Point[] { };
            }
            if (free[2].length != 0 && chessBoard.getPiece(free[2][0]) == null) {
                free[2] = new Point[] { };
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
