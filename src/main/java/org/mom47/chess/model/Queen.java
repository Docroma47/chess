package org.mom47.chess.model;


import java.util.Arrays;

public class Queen extends ChessPiece {
    private static final String WHITE_QUEEN = "♛";
    private static final String BLACK_QUEEN = "♕";
    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = getClearPath(chessBoard, position.getUpPath(7));
        free[1] = getClearPath(chessBoard, position.getUpRightPath(7));
        free[2] = getClearPath(chessBoard, position.getRightPath(7));
        free[3] = getClearPath(chessBoard, position.getDownRightPath(7));
        free[4] = getClearPath(chessBoard, position.getDownPath(7));
        free[5] = getClearPath(chessBoard, position.getDownLeftPath(7));
        free[6] = getClearPath(chessBoard, position.getLeftPath(7));
        free[7] = getClearPath(chessBoard, position.getUpLeftPath(7));
        return free;
    }

    public Queen(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_QUEEN);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_QUEEN);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.QUEEN);
    }
}
