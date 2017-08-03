package org.mom47.chess.model;


public class Chess {
    private ChessBoard chessBoard = new ChessBoard();
    private ChessPiece[] chessPieces;

    public Chess() {
        chessPieces = createChessPieces();
        setChessPiecesToChessBoard();
    }

    private ChessPiece[] createChessPieces() {
        ChessPiece[] figures = new ChessPiece[32];
        int j = 0;
        for (PieceColour color : PieceColour.values()) {
            figures[16 + j * 8] = new King(color, 5);
            figures[17 + j * 8] = new Queen(color, 4);
            figures[18 + j * 8] = new Bishop(color, 6);
            figures[19 + j * 8] = new Bishop(color, 3);
            figures[20 + j * 8] = new Knight(color, 7);
            figures[21 + j * 8] = new Knight(color, 2);
            figures[22 + j * 8] = new Rook(color, 8);
            figures[23 + j * 8] = new Rook(color, 1);
            j++;
        }

        for (int i = 0; i <= 7; i++) {
            figures[i] = new Pawn(PieceColour.WHITE, 1 + i);
            figures[i + 8] = new Pawn(PieceColour.BLACK, 1 + i);
        }

        return figures;
    }

    private void setChessPiecesToChessBoard() {
        for (int i = 0; i <= 31; i++) {
            chessBoard.setPiece(chessPieces[i]);
        }
    }

    public ChessPiece[] getChessPieces() {
        return chessPieces;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
