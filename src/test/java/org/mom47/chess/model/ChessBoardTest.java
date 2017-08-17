package org.mom47.chess.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {

    @Test
    public void testGetFreeSquires() throws Exception {
        ChessBoard chessBoard = new ChessBoard();

        assertEquals(64, chessBoard.getFreeSquires());

        King king = new King(PieceColour.BLACK, 0);
        chessBoard.setPiece(king);
        assertEquals(63, chessBoard.getFreeSquires());

        Queen queen = new Queen(PieceColour.WHITE, 7);
        chessBoard.setPiece(queen);
        assertEquals(62, chessBoard.getFreeSquires());
    }
}
