package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        int file = getPosition().getFile();
        int rank = getPosition().getRank();
        free[0][0] = new Point(file, rank + 1);
        free[1][0] = new Point(file + 1, rank + 1);
        free[2][0] = new Point(file + 1, rank);
        free[3][0] = new Point(file + 1, rank - 1);
        free[4][0] = new Point(file, rank - 1);
        free[5][0] = new Point(file - 1, rank - 1);
        free[6][0] = new Point(file - 1, rank);
        free[7][0] = new Point(file - 1, rank + 1);
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
