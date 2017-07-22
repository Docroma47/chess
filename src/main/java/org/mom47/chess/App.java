package org.mom47.chess;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.King;
import org.mom47.chess.model.Point;
import org.mom47.chess.model.Queen;

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
        Queen queen = new Queen();
        queen.setPositionX(1);
        queen.setPositionY(4);

        King king = new King();
        king.setPosition( new Point(1, 5));

        System.out.println(queen);
        System.out.println(king);
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
