package org.mom47.chess.model;


public class Knight extends ChessPiece {
    private static final String WHITE_KNIGHT = "♞";
    private static final String BLACK_KNIGHT = "♘";

    public Knight() { }

    @Override
    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = getClearPath(chessBoard, position.getUpRightHorsePath(1));
        free[1] = getClearPath(chessBoard, position.getRightUpHorsePath(1));
        free[2] = getClearPath(chessBoard, position.getRightDownHorsePath(1));
        free[3] = getClearPath(chessBoard, position.getDownRightHorsePath(1));
        free[4] = getClearPath(chessBoard, position.getDownLeftHorsePath(1));
        free[5] = getClearPath(chessBoard, position.getLeftDownHorsePath(1));
        free[6] = getClearPath(chessBoard, position.getLeftUpHorsePath(1));
        free[7] = getClearPath(chessBoard, position.getUpLeftHorsePath(1));

        return free;
    }

    public Knight(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_KNIGHT);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_KNIGHT);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.KNIGHT);
    }
}
