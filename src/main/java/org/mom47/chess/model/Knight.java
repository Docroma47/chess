package org.mom47.chess.model;


public class Knight extends ChessPiece {
    private static final String WHITE_KNIGHT = "♞";
    private static final String BLACK_KNIGHT = "♘";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0][0] = position.getUpLeftHorse();
        free[1][0] = position.getUpRightHorse();
        free[2][0] = position.getRightDownHorse();
        free[3][0] = position.getRightUpHorse();
        free[4][0] = position.getDownLeftHorse();
        free[5][0] = position.getDownRightHorse();
        free[6][0] = position.getLeftDownHorse();
        free[7][0] = position.getLeftUpHorse();
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
