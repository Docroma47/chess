package org.mom47.chess.model;


public class Queen extends ChessPiece {
    private static final String WHITE_QUEEN = "♛";
    private static final String BLACK_QUEEN = "♕";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = position.getUpPath(7);
        free[1] = position.getUpRightPath(7);
        free[2] = position.getRightPath(7);
        free[3] = position.getDownRightPath(7);
        free[4] = position.getDownPath(7);
        free[5] = position.getDownLeftPath(7);
        free[6] = position.getLeftPath(7);
        free[7] = position.getUpLeftPath(7);
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
