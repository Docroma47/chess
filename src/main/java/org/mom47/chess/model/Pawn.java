package org.mom47.chess.model;


public class Pawn extends ChessPiece {
    private static final String WHITE_PAWN = "♟";
    private static final String BLACK_PAWN = "♙";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0] = position.getUpPath(1);
        free[1] = position.getDownPath(1);
        return free;
    }

    public Pawn(PieceColour color,int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setPosition(new Point(file, 1));
            setSymbol(WHITE_PAWN);
        } else {
            setPosition(new Point(file, 6));
            setSymbol(BLACK_PAWN);
        }
        setPieceType(PieceType.PAWN);
    }
}
