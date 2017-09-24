package org.mom47.chess.model;


public class King extends ChessPiece {
    private static final String WHITE_KING = "♚";
    private static final String BLACK_KING = "♔";
    @Override
    public Point[][] getAvailablePaths() {
        Point[][] free = new Point[8][1];
        Point position = getPosition();
        if (position.getRank() == 0) {
            if (position.getFile() == 0) {
                free[0][0] = position.getUp();
                free[1][0] = position.getUpRight();
                free[2][0] = position.getRight();
            } else if (position.getFile() == 7) {
                free[0][0] = position.getUp();
                free[6][0] = position.getLeft();
                free[7][0] = position.getUpLeft();
            } else {
                free[0][0] = position.getUp();
                free[1][0] = position.getUpRight();
                free[2][0] = position.getRight();
                free[3][0] = //!free[3][0] = new Point[8][0];
                free[4][0] = //
                free[5][0] = //
                free[6][0] = position.getLeft();
                free[7][0] = position.getUpLeft();
            }
        } else if (position.getRank() == 7) {
            if (position.getFile() == 0) {
                free[2][0] = position.getRight();
                free[3][0] = position.getDownRight();
                free[4][0] = position.getDown();
            } else if (position.getFile() == 7) {
                free[4][0] = position.getDown();
                free[5][0] = position.getDownLeft();
                free[6][0] = position.getLeft();
            } else {
                free[2][0] = position.getRight();
                free[3][0] = position.getDownRight();
                free[4][0] = position.getDown();
                free[5][0] = position.getDownLeft();
                free[6][0] = position.getLeft();
            }
        } else if (position.getFile() == 0) {
            if (position.getRank() == 0) {
                free[0][0] = position.getUp();
                free[1][0] = position.getUpRight();
                free[2][0] = position.getRight();
            } else if (position.getRank() == 7) {
                free[2][0] = position.getRight();
                free[3][0] = position.getDownRight();
                free[4][0] = position.getDown();
            } else {
                free[0][0] = position.getUp();
                free[1][0] = position.getUpRight();
                free[2][0] = position.getRight();
                free[3][0] = position.getDownRight();
                free[4][0] = position.getDown();
            }
        } else if (position.getFile() == 7) {
            if (position.getRank() == 7) {
                free[4][0] = position.getDown();
                free[5][0] = position.getDownLeft();
                free[6][0] = position.getLeft();
            } else if (position.getRank() == 0) {
                free[0][0] = position.getUp();
                free[6][0] = position.getLeft();
                free[7][0] = position.getUpLeft();
            } else {
                free[0][0] = position.getUp();
                free[4][0] = position.getDown();
                free[5][0] = position.getDownLeft();
                free[6][0] = position.getLeft();
                free[7][0] = position.getUpLeft();
            }
        } else {
            free[0][0] = position.getUp();
            free[1][0] = position.getUpRight();
            free[2][0] = position.getRight();
            free[3][0] = position.getDownRight();
            free[4][0] = position.getDown();
            free[5][0] = position.getDownLeft();
            free[6][0] = position.getLeft();
            free[7][0] = position.getUpLeft();
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
