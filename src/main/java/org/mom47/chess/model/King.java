package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        free[0][0] = new Point(4, 5);
        free[1][0] = new Point(5, 5);
        free[2][0] = new Point(5, 4);
        free[3][0] = new Point(5, 3);
        free[4][0] = new Point(4, 3);
        free[5][0] = new Point(3, 3);
        free[6][0] = new Point(3, 4);
        free[7][0] = new Point(3, 5);
        return free;
    }

    public King(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_KING);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_KING);;
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.KING);
    }
}
