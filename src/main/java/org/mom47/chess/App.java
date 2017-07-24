package org.mom47.chess;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.*;

public class App {
    private static final String WHITE_KING = "♔";
    private static final String BLACK_KING = "♚";
    private static final String WHITE_QUEEN = "♕";
    private static final String BLACK_QUEEN = "♛";
    private static final String WHITE_ROOK = "♖";
    private static final String BLACK_ROOK = "♜";
    private static final String WHITE_BISHOP = "♗";
    private static final String BLACK_BISHOP = "♝";
    private static final String WHITE_KNIGHT = "♘";
    private static final String BLACK_KNIGHT = "♞";
    private static final String WHITE_PAWN = "♙";
    private static final String BLACK_PAWN = "♟";


    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        printChessDesk(1, 1);

        Point point = new Point(5, 1);
        King whiteking = new King(PieceColour.WHITE, WHITE_KING, point);
        print(whiteking);

        Point point1 = new Point(4, 1);
        Queen whitequeen = new Queen(PieceColour.WHITE, WHITE_QUEEN, point1);
        print(whitequeen);

        Point point2 = new Point(6, 1);
        Bishop whitebishop = new Bishop(PieceColour.WHITE, WHITE_BISHOP, point2);
        print(whitebishop);

        Point point3 = new Point(3, 1);
        Bishop whitebishop1 = new Bishop(PieceColour.WHITE, WHITE_BISHOP, point3);
        print(whitebishop1);

        Point point4 = new Point(2, 1);
        Knight whiteknight = new Knight(PieceColour.WHITE, WHITE_KNIGHT, point4);
        print(whiteknight);

        Point point5 = new Point(7, 1);
        Knight whiteknight1 = new Knight(PieceColour.WHITE, WHITE_KNIGHT, point5);
        print(whiteknight1);

        Point point6 = new Point(1, 1);
        Rook whiterook = new Rook(PieceColour.WHITE, WHITE_ROOK, point6);
        print(whiterook);

        Point point7 = new Point(8, 1);
        Rook whiterook1 = new Rook(PieceColour.WHITE, WHITE_ROOK, point7);
        print(whiterook1);

        Point point8 = new Point(8, 2);
        Pawn whitepawn = new Pawn(PieceColour.WHITE, WHITE_PAWN, point8);
        print(whitepawn);

        Point point9 = new Point(7, 2);
        Pawn whitepawn1 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point9);
        print(whitepawn1);

        Point point10 = new Point(6, 2);
        Pawn whitepawn2 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point10);
        print(whitepawn2);

        Point point11 = new Point(5, 2);
        Pawn whitepawn3 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point11);
        print(whitepawn3);

        Point point12 = new Point(4, 2);
        Pawn whitepawn4 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point12);
        print(whitepawn4);

        Point point13 = new Point(3, 2);
        Pawn whitepawn5 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point13);
        print(whitepawn5);

        Point point14 = new Point(2, 2);
        Pawn whitepawn6 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point14);
        print(whitepawn6);

        Point point15 = new Point(1, 2);
        Pawn whitepawn7 = new Pawn(PieceColour.WHITE, WHITE_PAWN, point15);
        print(whitepawn7);

        Point point16 = new Point(5, 8);
        King blackking = new King(PieceColour.BLACK, BLACK_KING, point16);
        print(blackking);

        Point point17 = new Point(4,8);
        Queen balckqueen = new Queen(PieceColour.BLACK, BLACK_QUEEN, point17);
        print(balckqueen);

        Point point18 = new Point(6, 8);
        Bishop blackbishop = new Bishop(PieceColour.BLACK, BLACK_BISHOP, point18);
        print(blackbishop);

        Point point19 = new Point(3, 8);
        Bishop blackbishop1 = new Bishop(PieceColour.BLACK, BLACK_BISHOP, point19);
        print(blackbishop1);

        Point point20 = new Point(2, 8);
        Knight blackknight1 = new Knight(PieceColour.BLACK, BLACK_KNIGHT, point20);
        print(blackknight1);

        Point point21 = new Point(7, 8);
        Knight blackknight = new Knight(PieceColour.BLACK, BLACK_KNIGHT, point21);
        print(blackknight);

        Point point22 = new Point(1, 8);
        Rook blackrook = new Rook(PieceColour.BLACK, BLACK_ROOK, point22);
        print(blackrook);

        Point point23 = new Point(8, 8);
        Rook blackrook1 = new Rook(PieceColour.BLACK, BLACK_ROOK, point23);
        print(blackrook1);

        Point point24 = new Point(8, 7);
        Pawn blackpawn7 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point24);
        print(blackpawn7);

        Point point25 = new Point(7, 7);
        Pawn blackpawn6 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point25);
        print(blackpawn6);

        Point point26 = new Point(6, 7);
        Pawn blackpawn5 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point26);
        print(blackpawn5);

        Point point27 = new Point(5, 7);
        Pawn blackpawn4 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point27);
        print(blackpawn4);

        Point point28 = new Point(4, 7);
        Pawn blackpawn3 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point28);
        print(blackpawn3);

        Point point29 = new Point(3, 7);
        Pawn blackpawn2 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point29);
        print(blackpawn2);

        Point point30 = new Point(2, 7);
        Pawn blackpawn1 = new Pawn(PieceColour.BLACK, BLACK_PAWN, point30);
        print(blackpawn1);

        Point point31 = new Point(1, 7);
        Pawn blackpawn = new Pawn(PieceColour.BLACK, BLACK_PAWN, point31);
        print(blackpawn);


        AnsiConsole.systemUninstall();
    }

    private static void print(ChessPiece chessPiece) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;

        Point position = chessPiece.getPosition();

        // translate king coordinates to the console coordinates


        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));

        print(x, y, chessPiece.getSymbol());
    }

    private static void printChess() {
        AnsiConsole.systemInstall();
        Ansi ansi = Ansi.ansi().eraseScreen();
        System.out.println(ansi);
        printChessDesk(5, 5);
        printFigures(5, 5);
        AnsiConsole.systemUninstall();
    }

    public static void drawVerticalLine(int x, int y, int length) {
        Ansi ansi = Ansi.ansi();
        for (; x <= length; x++)
        ansi.cursor(x, y).fg(Ansi.Color.WHITE).a("#");
        System.out.println(ansi);
    }

    public static void drawHorizontalLine(int x, int y, int length) {
        Ansi ansi = Ansi.ansi();
        for (; y <= length; y++)
        ansi.cursor(x, y).fg(Ansi.Color.WHITE).a("#");
        System.out.println(ansi);
    }

    private static void printChessDesk(int x, int y) {
        Ansi ansi = Ansi.ansi();
        print(x, y,      "  ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗");
        print(x, y + 1,  "8 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 2,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 3,  "7 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 4,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 5,  "6 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 6,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 7,  "5 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 8,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 9,  "4 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 10, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 11, "3 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 12, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 13, "2 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 14, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 15, "1 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 16, "  ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝");
        print(x, y + 17, "    A   B   C   D   E   F   G   H");
    }

    private static void print(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }

    private static void printFigures(int x, int y) {
        print(x + 20, y + 1, WHITE_KING);
        print(x + 16, y + 1, WHITE_QUEEN);
        print(x + 12, y + 1, WHITE_BISHOP);
        print(x + 8, y + 1, WHITE_KNIGHT);
        print(x + 4, y + 1, WHITE_ROOK);
        print(x + 32, y + 1, WHITE_ROOK);
        print(x + 24, y + 1, WHITE_BISHOP);
        print(x + 28, y + 1, WHITE_KNIGHT);
        print(x + 20, y + 15, BLACK_KING);
        print(x + 16, y + 15, BLACK_QUEEN);
        print(x + 12, y + 15, BLACK_BISHOP);
        print(x + 8, y + 15, BLACK_KNIGHT);
        print(x + 4, y + 15, BLACK_ROOK);
        print(x + 32, y + 15, BLACK_ROOK);
        print(x + 24, y + 15, BLACK_BISHOP);
        print(x + 28, y + 15, BLACK_KNIGHT);
        for (int i = 1; i <= 8; i++) {
            print(x + (4 * i), y + 3, WHITE_PAWN);
        }
        for (int i = 1; i <= 8; i++){
            print(x + (4 * i), y + 13, BLACK_PAWN);
        }
    }
}
