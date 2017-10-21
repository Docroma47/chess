package org.mom47.chess.view;


import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.Chess;
import org.mom47.chess.model.ChessPiece;
import org.mom47.chess.model.Point;
public class ChessBashView {
    private Chess chess;

    public ChessBashView(Chess chess) {
        this.chess = chess;
    }

    public void print() {
        AnsiConsole.systemInstall();
        System.out.println(Ansi.ansi().reset().eraseScreen().toString());

        printChessBoard();
        printChessPieces();

        System.out.println(Ansi.ansi().cursor(30, 0).a("").reset().toString());
        AnsiConsole.systemUninstall();
        printcursor();
    }

    private void printChessPieces() {
        for (int i = 0; i <= 31; i++) {
            print(chess.getChessPieces()[i]);
        }
    }

    private static void print(ChessPiece chessPiece) {
        if (chessPiece.getIsCaptured() == false) {
            int horizontalNumberOfSymbolsPerCell = 4;
            int verticalNumberOfSymbolsPerCell = 2;
            int boardInitialPointX = 5;
            int bardInitialPointY = 0;
            int boardHeight = 16;

            Point position = chessPiece.getPosition();

            int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
            int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));

            print(x, y, chessPiece.getSymbol());
        }
    }

    private void printChessBoard() {
        int x = 1;
        int y = 1;
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

    private void printcursor() {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 5;
        int bardInitialPointY = 0;
        int boardHeight = 16;
        Point cursor = chess.cursor;
        int rank = bardInitialPointY + (boardHeight - (cursor.getRank() * verticalNumberOfSymbolsPerCell));
        int file = boardInitialPointX + (cursor.getFile() * horizontalNumberOfSymbolsPerCell);
        System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color.YELLOW).a("▒"));
    }

    private static void print(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }
}
