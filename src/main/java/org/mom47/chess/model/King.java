package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        free[0][0] = position.getUp();
        free[1][0] = position.getUpRight();
        free[2][0] = position.getRight();
        free[3][0] = position.getDownRight();
        free[4][0] = position.getDown();
        free[5][0] = position.getDownLeft();
        free[6][0] = position.getLeft();
        free[7][0] = position.getUpLeft();
        if (getPosition().getFile() > 7 || getPosition().getFile() < 0 ) {
            getPosition().getFile();
        }
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
