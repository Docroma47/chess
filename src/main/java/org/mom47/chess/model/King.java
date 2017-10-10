package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = position.getUpPath(1);
        free[1] = position.getUpRightPath(1);
        free[2] = position.getRightPath(1);
        free[3] = position.getDownRightPath(1);
        free[4] = position.getDownPath(1);
        free[5] = position.getDownLeftPath(1);
        free[6] = position.getLeftPath(1);
        free[7] = position.getUpLeftPath(1);
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
