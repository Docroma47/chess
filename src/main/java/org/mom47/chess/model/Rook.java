package org.mom47.chess.model;


public class Rook extends ChessPiece {
    private static final String WHITE_ROOK = "♜";
    private static final String BLACK_ROOK = "♖";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[4][8];
        Point position = getPosition();
        free[0] = position.getUpPath(7);
        free[2] = position.getRightPath(7);
        free[4] = position.getDownPath(7);
        free[6] = position.getLeftPath(7);
        return free;
    }

    public Rook(PieceColour color, int file) {
        super(color);
        if (color == PieceColour.WHITE) {
            setSymbol(WHITE_ROOK);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_ROOK);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.ROOK);
    }
}
