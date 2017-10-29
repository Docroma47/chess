package org.mom47.chess.model;


import java.util.Arrays;

public class Rook extends ChessPiece {
    private static final String WHITE_ROOK = "♜";
    private static final String BLACK_ROOK = "♖";
    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[4][8];
        Point position = getPosition();
        free[0] = getClearPath(chessBoard, position.getUpPath(7));
        free[1] = getClearPath(chessBoard, position.getRightPath(7));
        free[2] = getClearPath(chessBoard, position.getDownPath(7));
        free[3] = getClearPath(chessBoard, position.getLeftPath(7));
        return free;
    }

    public Rook(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_ROOK);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_ROOK);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.ROOK);
    }
}
