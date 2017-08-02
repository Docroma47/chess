package org.mom47.chess.model.view;


import org.fusesource.jansi.Ansi;
import org.mom47.chess.model.Chess;

public class ChessBashView {
    private Chess chess;

    public ChessBashView(Chess chess) {
    }

    public void print(int x, int y) {
        printChessBoard(x, y);
    }

    private static void printChessBoard(int x, int y) {
        printChessBoard(x, y,      "  ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗");
        printChessBoard(x, y + 1,  "8 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 2,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 3,  "7 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 4,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 5,  "6 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 6,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 7,  "5 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 8,  "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 9,  "4 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 10, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 11, "3 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 12, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 13, "2 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 14, "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        printChessBoard(x, y + 15, "1 ║   │   │   │   │   │   │   │   ║");
        printChessBoard(x, y + 16, "  ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝");
        printChessBoard(x, y + 17, "    A   B   C   D   E   F   G   H");
    }

    private static void printChessBoard(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }

    private void printChessPieces() {
        chess.getChessPiece();
    }
}
