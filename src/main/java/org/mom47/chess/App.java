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
        King whiteking = new King();
        whiteking.setPosition(point);
        whiteking.setColor(PieceColour.WHITE);
        whiteking.setSymbol(WHITE_KING);
        print(whiteking);

        Queen whitequeen = new Queen();
        whitequeen.setPosition(new Point(4, 1));
        whitequeen.setSymbol(WHITE_QUEEN);
        print(whitequeen);

        Point point1 = new Point(6, 1);
        Bishop whitebishop = new Bishop();
        whitebishop.setPosition(point1);
        whitebishop.setColor(PieceColour.WHITE);
        whitebishop.setSymbol(WHITE_BISHOP);
        print(whitebishop);

        Point point2 = new Point(3, 1);
        Bishop whitebishop1 = new Bishop();
        whitebishop1.setPosition(point2);
        whitebishop1.setColor(PieceColour.WHITE);
        whitebishop1.setSymbol(WHITE_BISHOP);
        print(whitebishop1);

        Point point3 = new Point(2, 1);
        Knight whiteknight = new Knight();
        whiteknight.setPosition(point3);
        whiteknight.setColor(PieceColour.WHITE);
        whiteknight.setSymbol(WHITE_KNIGHT);
        print(whiteknight);

        Point point4 = new Point(7, 1);
        Knight whiteknight1 = new Knight();
        whiteknight1.setPosition(point4);
        whiteknight1.setColor(PieceColour.WHITE);
        whiteknight1.setSymbol(WHITE_KNIGHT);
        print(whiteknight1);

        Point point5 = new Point(1, 1);
        Rook whiterook = new Rook();
        whiterook.setPosition(point5);
        whiterook.setColor(PieceColour.WHITE);
        whiterook.setSymbol(WHITE_ROOK);
        print(whiterook);

        Point point6 = new Point(8, 1);
        Rook whiterook1 = new Rook();
        whiterook1.setPosition(point6);
        whiterook1.setColor(PieceColour.WHITE);
        whiterook1.setSymbol(WHITE_ROOK);
        print(whiterook1);

        Point point7 = new Point(8, 2);
        Pawn whitepawn = new Pawn();
        whitepawn.setPosition(point7);
        whitepawn.setColor(PieceColour.WHITE);
        whitepawn.setSymbol(WHITE_PAWN);
        print(whitepawn);

        Point point8 = new Point(7, 2);
        Pawn whitepawn1 = new Pawn();
        whitepawn1.setPosition(point8);
        whitepawn1.setColor(PieceColour.WHITE);
        whitepawn1.setSymbol(WHITE_PAWN);
        print(whitepawn1);

        Point point9 = new Point(6, 2);
        Pawn whitepawn2 = new Pawn();
        whitepawn2.setPosition(point9);
        whitepawn2.setColor(PieceColour.WHITE);
        whitepawn2.setSymbol(WHITE_PAWN);
        print(whitepawn2);

        Point point10 = new Point(5, 2);
        Pawn whitepawn3 = new Pawn();
        whitepawn3.setPosition(point10);
        whitepawn3.setColor(PieceColour.WHITE);
        whitepawn3.setSymbol(WHITE_PAWN);
        print(whitepawn3);

        Point point11 = new Point(4, 2);
        Pawn whitepawn4 = new Pawn();
        whitepawn4.setPosition(point11);
        whitepawn4.setColor(PieceColour.WHITE);
        whitepawn4.setSymbol(WHITE_PAWN);
        print(whitepawn4);

        Point point12 = new Point(3, 2);
        Pawn whitepawn5 = new Pawn();
        whitepawn5.setPosition(point12);
        whitepawn5.setColor(PieceColour.WHITE);
        whitepawn5.setSymbol(WHITE_PAWN);
        print(whitepawn5);

        Point point13 = new Point(2, 2);
        Pawn whitepawn6 = new Pawn();
        whitepawn6.setPosition(point13);
        whitepawn6.setColor(PieceColour.WHITE);
        whitepawn6.setSymbol(WHITE_PAWN);
        print(whitepawn6);

        Point point14 = new Point(1, 2);
        Pawn whitepawn7 = new Pawn();
        whitepawn7.setPosition(point14);
        whitepawn7.setColor(PieceColour.WHITE);
        whitepawn7.setSymbol(WHITE_PAWN);
        print(whitepawn7);

        Point point29 = new Point(5, 8);
        King blackking = new King();
        blackking.setPosition(point29);
        blackking.setColor(PieceColour.BLACK);
        blackking.setSymbol(BLACK_KING);
        print(blackking);

        Queen balckqueen = new Queen();
        balckqueen.setPosition(new Point(4, 8));
        balckqueen.setSymbol(BLACK_QUEEN);
        print(balckqueen);

        Point point28 = new Point(6, 8);
        Bishop blackbishop = new Bishop();
        blackbishop.setPosition(point28);
        blackbishop.setColor(PieceColour.BLACK);
        blackbishop.setSymbol(BLACK_BISHOP);
        print(blackbishop);

        Point point27 = new Point(3, 8);
        Bishop blackbishop1 = new Bishop();
        blackbishop1.setPosition(point27);
        blackbishop1.setColor(PieceColour.BLACK);
        blackbishop1.setSymbol(BLACK_BISHOP);
        print(blackbishop1);

        Point point26 = new Point(2, 8);
        Knight blackknight1 = new Knight();
        blackknight1.setPosition(point26);
        blackknight1.setColor(PieceColour.BLACK);
        blackknight1.setSymbol(BLACK_KNIGHT);
        print(blackknight1);

        Point point25 = new Point(7, 8);
        Knight blackknight = new Knight();
        blackknight.setPosition(point25);
        blackknight.setColor(PieceColour.BLACK);
        blackknight.setSymbol(BLACK_KNIGHT);
        print(blackknight);

        Point point24 = new Point(1, 8);
        Rook blackrook = new Rook();
        blackrook.setPosition(point24);
        blackrook.setColor(PieceColour.BLACK);
        blackrook.setSymbol(BLACK_ROOK);
        print(blackrook);

        Point point23 = new Point(8, 8);
        Rook blackrook1 = new Rook();
        blackrook1.setPosition(point23);
        blackrook1.setColor(PieceColour.BLACK);
        blackrook1.setSymbol(BLACK_ROOK);
        print(blackrook1);

        Point point22 = new Point(8, 7);
        Pawn blackpawn7 = new Pawn();
        blackpawn7.setPosition(point22);
        blackpawn7.setColor(PieceColour.BLACK);
        blackpawn7.setSymbol(BLACK_PAWN);
        print(blackpawn7);

        Point point21 = new Point(7, 7);
        Pawn blackpawn6 = new Pawn();
        blackpawn6.setPosition(point21);
        blackpawn6.setColor(PieceColour.BLACK);
        blackpawn6.setSymbol(BLACK_PAWN);
        print(blackpawn6);

        Point point20 = new Point(6, 7);
        Pawn blackpawn5 = new Pawn();
        blackpawn5.setPosition(point20);
        blackpawn5.setColor(PieceColour.BLACK);
        blackpawn5.setSymbol(BLACK_PAWN);
        print(blackpawn5);

        Point point19 = new Point(5, 7);
        Pawn blackpawn4 = new Pawn();
        blackpawn4.setPosition(point19);
        blackpawn4.setColor(PieceColour.BLACK);
        blackpawn4.setSymbol(BLACK_PAWN);
        print(blackpawn4);

        Point point18 = new Point(4, 7);
        Pawn blackpawn3 = new Pawn();
        blackpawn3.setPosition(point18);
        blackpawn3.setColor(PieceColour.BLACK);
        blackpawn3.setSymbol(BLACK_PAWN);
        print(blackpawn3);

        Point point17 = new Point(3, 7);
        Pawn blackpawn2 = new Pawn();
        blackpawn2.setPosition(point17);
        blackpawn2.setColor(PieceColour.BLACK);
        blackpawn2.setSymbol(BLACK_PAWN);
        print(blackpawn2);

        Point point16 = new Point(2, 7);
        Pawn blackpawn1 = new Pawn();
        blackpawn1.setPosition(point16);
        blackpawn1.setColor(PieceColour.BLACK);
        blackpawn1.setSymbol(BLACK_PAWN);
        print(blackpawn1);

        Point point15 = new Point(1, 7);
        Pawn blackpawn = new Pawn();
        blackpawn.setPosition(point15);
        blackpawn.setColor(PieceColour.BLACK);
        blackpawn.setSymbol(BLACK_PAWN);
        print(blackpawn);


        AnsiConsole.systemUninstall();
        System.out.println(whitebishop);
        System.out.println(whiteking);
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
