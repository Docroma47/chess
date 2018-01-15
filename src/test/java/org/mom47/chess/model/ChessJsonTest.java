package org.mom47.chess.model;


import org.junit.Assert;
import org.junit.Test;
import org.mom47.chess.controller.ChessController;
import org.mom47.chess.view.ChessBashView;

public class ChessJsonTest {

    @Test
    public void ChessModelTest() throws Exception {
        String fileName = "ChessJsonTest.json";
        Chess original = new Chess();
        ChessBashView chessBashView = new ChessBashView(original);
        ChessController controller = new ChessController(original, chessBashView);

        ChessPiece chessPiece = original.getChessPieces()[0];
        original.getChessBoard().move(chessPiece.getPosition(), chessPiece.getPosition().getUp());

        controller.saveTest(original, fileName);

        Chess loaded = controller.loadTest(fileName);
        ChessBashView view = new ChessBashView(loaded);
        ChessController chessController = new ChessController(loaded, view);

        int length = 31;
        for (int i = 0; i <= length; i++) {
            Assert.assertEquals(original.getChessPieces()[i].getPosition(), loaded.getChessPieces()[i].getPosition());
            Assert.assertEquals(original.getChessPieces()[i].getColor(), loaded.getChessPieces()[i].getColor());
            Assert.assertEquals(original.getChessPieces()[i].getPieceType(), loaded.getChessPieces()[i].getPieceType());
            Assert.assertEquals(original.getChessPieces()[i].getSymbol(), loaded.getChessPieces()[i].getSymbol());
            Assert.assertEquals(original.getChessPieces()[i].toString(), loaded.getChessPieces()[i].toString());
            Assert.assertEquals(original.cursor, loaded.cursor);
            Assert.assertEquals(original.getChessBoard().getChessPieces()[i], loaded.getChessBoard().getChessPieces()[i]);
            Assert.assertEquals(original.getChessBoard(), loaded.getChessBoard());
            Assert.assertEquals(original.selectedPiece, loaded.selectedPiece);
            Assert.assertEquals(original.getChessPieces()[i], loaded.getChessPieces()[i]);
            Assert.assertEquals(original.side, loaded.side);
        }
    }
}
