package org.mom47.chess.model;


import org.junit.Assert;
import org.junit.Test;

public class KnightTest {
    @Test
    public void testGetAvailablePaths() throws Exception {
        ChessBoard chessBoard = new ChessBoard();
        Knight knight = new Knight(PieceColour.BLACK, 4);
        chessBoard.setPiece(knight);

        chessBoard.move(knight.getPosition(), new Point(4, 4));
        Point position = knight.getPosition();
        Assert.assertEquals(new Point(4, 4), position);

        Point[][] availablePaths = knight.getAvailablePaths();
        Assert.assertEquals(8, availablePaths.length);

        // check that every paths is 1 squire long
        Assert.assertEquals(1, availablePaths[0].length);
        Assert.assertEquals(1, availablePaths[1].length);
        Assert.assertEquals(1, availablePaths[2].length);
        Assert.assertEquals(1, availablePaths[3].length);
        Assert.assertEquals(1, availablePaths[4].length);
        Assert.assertEquals(1, availablePaths[5].length);
        Assert.assertEquals(1, availablePaths[6].length);
        Assert.assertEquals(1, availablePaths[7].length);

        // check the path UP-Left
        Assert.assertEquals(new Point(3, 6), availablePaths[0][0]);

        // check the path UP-RIGHT
        Assert.assertEquals(new Point(5, 6), availablePaths[1][0]);

        // check the path RIGHT-Down
        Assert.assertEquals(new Point(6, 3), availablePaths[2][0]);

        // check the path RIGHT-UP
        Assert.assertEquals(new Point(6, 5), availablePaths[3][0]);

        // check the path DOWN-Left
        Assert.assertEquals(new Point(3, 2), availablePaths[4][0]);

        // check the path DOWN-Right
        Assert.assertEquals(new Point(5, 2), availablePaths[5][0]);

        // check the path LEFT-UP
        Assert.assertEquals(new Point(2, 3), availablePaths[6][0]);

        // check the path LEFT-Down
        Assert.assertEquals(new Point(2, 5), availablePaths[7][0]);

        // moving the king by one squire to he right ==================

        chessBoard.move(knight.getPosition(), new Point(5, 4));
        position = knight.getPosition();
        Assert.assertEquals(new Point(5, 4), position);

        availablePaths = knight.getAvailablePaths();
        Assert.assertEquals(8, availablePaths.length);

        // check that every paths is 1 squire long
        Assert.assertEquals(1, availablePaths[0].length);
        Assert.assertEquals(1, availablePaths[1].length);
        Assert.assertEquals(1, availablePaths[2].length);
        Assert.assertEquals(1, availablePaths[3].length);
        Assert.assertEquals(1, availablePaths[4].length);
        Assert.assertEquals(1, availablePaths[5].length);
        Assert.assertEquals(1, availablePaths[6].length);
        Assert.assertEquals(1, availablePaths[7].length);

        // check the path UP-Left
        Assert.assertEquals(new Point(4, 6), availablePaths[0][0]);

        // check the path UP-RIGHT
        Assert.assertEquals(new Point(6, 6), availablePaths[1][0]);

        // check the path RIGHT-Down
        Assert.assertEquals(new Point(7, 3), availablePaths[2][0]);

        // check the path RIGHT-UP
        Assert.assertEquals(new Point(7, 5), availablePaths[3][0]);

        // check the path DOWN-Left
        Assert.assertEquals(new Point(4, 2), availablePaths[4][0]);

        // check the path DOWN-Right
        Assert.assertEquals(new Point(6, 2), availablePaths[5][0]);

        // check the path LEFT-UP
        Assert.assertEquals(new Point(3, 3), availablePaths[6][0]);

        // check the path LEFT-Down
        Assert.assertEquals(new Point(3, 5), availablePaths[7][0]);

        // moving the king to the bottom edge ==================

        chessBoard.move(knight.getPosition(), new Point(4, 0));
        position = knight.getPosition();
        Assert.assertEquals(new Point(4, 0), position);

        availablePaths = knight.getAvailablePaths();
        Assert.assertEquals(8, availablePaths.length);

        // check that every paths is 1 squire long
        Assert.assertEquals(1, availablePaths[0].length);
        Assert.assertEquals(1, availablePaths[1].length);
        Assert.assertEquals(1, availablePaths[2].length);
        Assert.assertEquals(0, availablePaths[3].length);
        Assert.assertEquals(0, availablePaths[4].length);
        Assert.assertEquals(0, availablePaths[5].length);
        Assert.assertEquals(1, availablePaths[6].length);
        Assert.assertEquals(1, availablePaths[7].length);

        // check the path UP
        Assert.assertEquals(new Point(4, 1), availablePaths[0][0]);

        // check the path UP-RIGHT
        Assert.assertEquals(new Point(4, 1), availablePaths[1][0]);

        // check the path RIGHT
        Assert.assertEquals(new Point(5, 0), availablePaths[2][0]);

        // check the path LEFT
        Assert.assertEquals(new Point(3, 0), availablePaths[6][0]);

        // check the path UP-LEFT
        Assert.assertEquals(new Point(3, 1), availablePaths[7][0]);
    }
}
