package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChessBoardTest {
    @Test
    public void testGetFreeSquaresNumber() throws Exception {
        ChessBoard chessBoard = new ChessBoard();

        Assert.assertEquals(64, chessBoard.getFreeSquaresNumber());

        King king = new King(PieceColour.BLACK, 0);
        chessBoard.setPiece(king);
        Assert.assertEquals(63, chessBoard.getFreeSquaresNumber());

        Queen queen = new Queen(PieceColour.WHITE, 7);
        chessBoard.setPiece(queen);
        Assert.assertEquals(62, chessBoard.getFreeSquaresNumber());
    }

    @Test
    public void testGetFreeSquaresEmptyBoard() {
        ChessBoard chessBoard = new ChessBoard();

        // first test case
        // conditions:
        // empty chess board

        // execution
        Point[] squares = chessBoard.getFreeSquares();

        // expectations:
        // not null array of 64 length
        Assert.assertNotNull(squares);
        Assert.assertEquals(64, squares.length);
        // each of array element must have an instance of Point object which represents an empty square on the board
        // we need to make sure that all squares of the board exist in the result of execution getFreeSquares method
        // we will create two loops to run though all squares of the chess board and we will try to find all of them
        // in the resulting array returned by getFreeSquares

        // running through files (horizontally)
        for (int file = 0; file < 8; file++) {
            // running through ranks (vertically)
            for (int rank = 0; rank < 8; rank++) {
                // making sure that we can find all squares
                Assert.assertNotNull(findPointByFileAndRank(squares, file, rank));
            }
        }
    }

    @Test
    public void testGetFreeSquaresWithAllChessPiecesOnTheBoard() {
        ChessBoard chessBoard = new ChessBoard();

        // second test case
        // conditions:
        // chess board is full with chess pieces
        // running through files (horizontally)
        for (int file = 0; file < 8; file++) {
            // running through ranks (vertically)
            for (int rank = 0; rank < 8; rank++) {
                // adding a new chess piece on the board
                ChessPiece chessPiece = new ChessPiece(PieceColour.WHITE);
                chessPiece.setPosition(new Point(file, rank));
                chessBoard.setPiece(chessPiece);
            }
        }

        // execution
        Point[] squares = chessBoard.getFreeSquares();

        // expectations:
        // not null array of zero length
        Assert.assertNotNull(squares);
        Assert.assertEquals(0, squares.length);
    }

    @Test
    public void testGetFreeSquaresWithSinglePieceOnTheBoard() {
        ChessBoard chessBoard = new ChessBoard();

        // third test case
        // conditions:
        // chess board has only one chess piece by (4,4) (file, rank)

        Point point = new Point(4, 4);

        ChessPiece chessPiece = new ChessPiece(PieceColour.WHITE);
        chessPiece.setPosition(new Point(point.getFile(), point.getRank()));
        chessBoard.setPiece(chessPiece);

        // execution
        Point[] squares = chessBoard.getFreeSquares();

        // expectations:
        // not null array, length is 63
        Assert.assertNotNull(squares);
        Assert.assertEquals(63, squares.length);
        // array contains 63 Points, there should NOT be the pouint by 4,4 coordinate
        Point first = new Point(4, 4);
        for (int i = 0; i < squares.length; i++) {
            Assert.assertNotEquals(point, squares[i]);
        }
    }

    /**
     * This method tries to find a point by its coordinates. If no any point found, then null is returned.
     * @param points an array of points
     * @param file file to find
     * @param rank rank to find
     * @return a point with matching file and rank
     */
    private Point findPointByFileAndRank(Point[] points, int file, int rank) {
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            if (point.getFile() == file && point.getRank() == rank) {
                return point;
            }
        }
        return null;
    }

    @Test
    public void testGetSetPiece() {
        ChessBoard chessBoard = new ChessBoard();

        int figureOnefile = 6;
        int figureOnerank = 6;
        ChessPiece chessPiece = new ChessPiece(PieceColour.BLACK);
        chessPiece.setPosition(new Point(figureOnefile, figureOnerank));
        chessBoard.setPiece(chessPiece);

        int figureTwofile = 5;
        int figureTwoRank = 5;
        ChessPiece piece = new ChessPiece(PieceColour.WHITE);
        piece.setPosition(new Point(figureTwofile, figureTwoRank));
        chessBoard.setPiece(piece);

        Assert.assertEquals(chessBoard.getPiece(new Point(5, 5)), piece);
        Assert.assertEquals(chessBoard.getPiece(new Point(6, 6)), chessPiece);
    }

    @Test
    public void testSetPieceAlreadyOccupied() {
        int file = 2;
        int rank = 6;
        ChessBoard chessBoard = new ChessBoard();


        ChessPiece first = new ChessPiece(PieceColour.BLACK);
        first.setPosition(new Point(file, rank));
        chessBoard.setPiece(first);

        try {
            ChessPiece second = new ChessPiece(PieceColour.WHITE);
            second.setPosition(new Point(file, rank));
            chessBoard.setPiece(second);
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testMoveAlreadyOccupiedSquares() {
        int file = 2;
        int rank = 6;
        ChessBoard chessBoard = new ChessBoard();

        ChessPiece first = new ChessPiece(PieceColour.BLACK);
        first.setPosition(new Point(file, rank));
        chessBoard.setPiece(first);

        int fileTwo = 5;
        int rankTwo = 6;
        try {
            ChessPiece second = new ChessPiece(PieceColour.WHITE);
            second.setPosition(new Point(fileTwo, rankTwo));
            chessBoard.move(second.getPosition(), first.getPosition());
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetChessPieces() {
        ChessBoard chessBoard = new ChessBoard();
        int figureOnefile = 6;
        int figureOnerank = 6;
        ChessPiece chessPiece = new ChessPiece(PieceColour.BLACK);
        chessPiece.setPosition(new Point(figureOnefile, figureOnerank));
        chessBoard.setPiece(chessPiece);

        int figureTwofile = 5;
        int figureTwoRank = 5;
        ChessPiece piece = new ChessPiece(PieceColour.WHITE);
        piece.setPosition(new Point(figureTwofile, figureTwoRank));
        chessBoard.setPiece(piece);

        ChessPiece[] squares = chessBoard.getChessPieces();


        Assert.assertEquals(2, chessBoard.getChessPiecesNumber());
        Assert.assertEquals(PieceColour.BLACK, squares[1].getColor());
        Assert.assertEquals(PieceColour.WHITE, squares[0].getColor());
        Assert.assertEquals(chessPiece.getPosition().getRank(), squares[1].getPosition().getRank());
        Assert.assertEquals(chessPiece.getPosition().getFile(), squares[1].getPosition().getFile());
        Assert.assertEquals(piece.getPosition().getRank(), squares[0].getPosition().getRank());
        Assert.assertEquals(piece.getPosition().getFile(), squares[0].getPosition().getFile());

        chessBoard.remove(chessPiece.getPosition());

        Assert.assertEquals(1, chessBoard.getChessPiecesNumber());
        Assert.assertEquals(PieceColour.WHITE, squares[0].getColor());
        Assert.assertEquals(piece.getPosition().getRank(), squares[0].getPosition().getRank());
        Assert.assertEquals(piece.getPosition().getFile(), squares[0].getPosition().getFile());

    }

    @Test
    public void testGetChessPiecesNumber() {
        ChessBoard chessBoard = new ChessBoard();

        Assert.assertEquals(0, chessBoard.getChessPiecesNumber());

        King king = new King(PieceColour.BLACK, 0);
        chessBoard.setPiece(king);
        Assert.assertEquals(1, chessBoard.getChessPiecesNumber());

        Queen queen = new Queen(PieceColour.WHITE, 7);
        chessBoard.setPiece(queen);
        Assert.assertEquals(2, chessBoard.getChessPiecesNumber());
    }
}
