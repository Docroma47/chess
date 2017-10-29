package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;

public class ChessPieceTest {
    @Test
    public void getClearPath() {
        Pawn pawn = new Pawn(PieceColour.BLACK, 4);
        Rook rook = new Rook(PieceColour.WHITE, 4);

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setPiece(rook);
        chessBoard.move(rook.getPosition(), new Point(0, 0));

        chessBoard.setPiece(pawn);
        chessBoard.move(pawn.getPosition(),new Point(0, 3));
        int length = rook.getAvailablePaths(chessBoard)[0].length;

        Assert.assertEquals(length, 3);
    }
}
