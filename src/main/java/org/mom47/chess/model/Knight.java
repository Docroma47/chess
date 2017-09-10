package org.mom47.chess.model;


public class Knight extends ChessPiece {
    private static final String WHITE_KNIGHT = "♞";
    private static final String BLACK_KNIGHT = "♘";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
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
