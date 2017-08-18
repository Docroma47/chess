package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;

public class ChessBoardTest {

    @Test
    public void testGetFreeSquires() throws Exception {
        ChessBoard chessBoard = new ChessBoard();

        Assert.assertEquals(64, chessBoard.getFreeSquiresNumber());

        King king = new King(PieceColour.BLACK, 0);
        chessBoard.setPiece(king);
        Assert.assertEquals(63, chessBoard.getFreeSquiresNumber());

        Queen queen = new Queen(PieceColour.WHITE, 7);
        chessBoard.setPiece(queen);
        Assert.assertEquals(62, chessBoard.getFreeSquiresNumber());
    }
}
