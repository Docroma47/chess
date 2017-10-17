package org.mom47.chess.model;


public class Bishop extends ChessPiece {
    private static final String WHITE_BISHOP = "♝";
    private static final String BLACK_BISHOP = "♗";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[4][1];
        Point position = getPosition();
        free[0] = position.getUpRightPath(7);
        free[1] = position.getDownRightPath(7);
        free[2] = position.getDownLeftPath(7);
        free[3] = position.getUpLeftPath(7);
        return free;
    }

    public Bishop(PieceColour color, int file) {
        super(color);
        if(color == PieceColour.WHITE) {
            setSymbol(WHITE_BISHOP);
            setPosition(new Point(file, 0));
        } else {
            setSymbol(BLACK_BISHOP);
            setPosition(new Point(file, 7));
        }
        setPieceType(PieceType.BISHOP);
    }
}
