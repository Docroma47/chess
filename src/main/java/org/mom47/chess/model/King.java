package org.mom47.chess.model;


import java.util.Arrays;

public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = getClearPath(chessBoard, position.getUpPath(1));
        free[1] = getClearPath(chessBoard, position.getUpRightPath(1));
        free[2] = getClearPath(chessBoard, position.getRightPath(1));
        free[3] = getClearPath(chessBoard, position.getDownRightPath(1));
        free[4] = getClearPath(chessBoard, position.getDownPath(1));
        free[5] = getClearPath(chessBoard, position.getDownLeftPath(1));
        free[6] = getClearPath(chessBoard, position.getLeftPath(1));
        free[7] = getClearPath(chessBoard, position.getUpLeftPath(1));
        return free;
    }

    public King(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_KING);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_KING);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.KING);
    }
}
