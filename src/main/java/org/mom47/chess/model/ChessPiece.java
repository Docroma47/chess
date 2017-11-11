package org.mom47.chess.model;


import java.util.Arrays;

public class ChessPiece {
    private PieceType pieceType;
    private PieceColour color;
    private String state;
    private String symbol;
    private Point position;
    private Boolean isCaptured = false;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setColor(PieceColour color) {
        this.color = color;
    }

    public PieceColour getColor() {
        return color;
    }

    public ChessPiece(PieceColour color) {
        setColor(color);
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public Boolean getIsCaptured() {
        return isCaptured;
    }

    public Point[][] getAvailablePaths(ChessBoard chessBoard) {
        return null;
    }

    public Point[] getClearPath(ChessBoard chessBoard, Point[] path) {
        for (int i = 0; i <= path.length - 1; i++) {
            if (!(getSymbol().equals("♞"))) {
                if (chessBoard.getPiece(path[i]) != null && getColor() != chessBoard.getPiece(path[i]).getColor()) {
                    path = Arrays.copyOf(path, i + 1);
                    break;
                } else if (chessBoard.getPiece(path[i]) != null && getColor() == chessBoard.getPiece(path[i]).getColor()) {
                    path = Arrays.copyOf(path, i);
                    break;
                }
            } else {
                if (chessBoard.getPiece(path[i]) != null && getColor() != chessBoard.getPiece(path[i]).getColor()) {
                    path = Arrays.copyOf(path, i + 1);
                    break;
                } else if (chessBoard.getPiece(path[i]) != null && getColor() == chessBoard.getPiece(path[i]).getColor()) {
                    path = Arrays.copyOf(path, 0);
                    break;
                }
            }
        }
        return path;
    }

    @Override
    public String toString() {
        switch(getPosition().getFile()) {
            case 0:
                state = " - A" + (getPosition().getRank() + 1);
                break;
            case 1:
                state = " - B" + (getPosition().getRank() + 1);
                break;
            case 2:
                state = " - C" + (getPosition().getRank() + 1);
                break;
            case 3:
                state = " - D" + (getPosition().getRank() + 1);
                break;
            case 4:
                state = " - E" + (getPosition().getRank() + 1);
                break;
            case 5:
                state = " - F" + (getPosition().getRank() + 1);
                break;
            case 6:
                state = " - G" + (getPosition().getRank() + 1);
                break;
            case 7:
                state = " - H" + (getPosition().getRank() + 1);
                break;
        }

        if(getIsCaptured() == true) {
            state = " - captured";
        }

        return this.getSymbol() + state;
    }
}
