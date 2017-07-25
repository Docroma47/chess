package org.mom47.chess;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.*;

public class App {
    public static void main(String[] args) {
        ChessPiece[] figures = new ChessPiece[32];
        AnsiConsole.systemInstall();
        printChessDesk(1, 1);

        figures[16] = new King(PieceColour.WHITE, 5);

        figures[17] = new Queen(PieceColour.WHITE, 4);

        figures[18] = new Bishop(PieceColour.WHITE, 6);

        figures[19] = new Bishop(PieceColour.WHITE, 3);

        figures[20] = new Knight(PieceColour.WHITE, 7);

        figures[21] = new Knight(PieceColour.WHITE, 2);

        figures[22] = new Rook(PieceColour.WHITE, 8);

        figures[23] = new Rook(PieceColour.WHITE, 1);

        figures[24] = new King(PieceColour.BLACK, 5);

        figures[25] = new Queen(PieceColour.BLACK, 4);

        figures[26] = new Bishop(PieceColour.BLACK, 6);

        figures[27] = new Bishop(PieceColour.BLACK, 3);

        figures[28] = new Knight(PieceColour.BLACK, 7);

        figures[29] = new Knight(PieceColour.BLACK, 2);

        figures[30] = new Rook(PieceColour.BLACK, 8);

        figures[31] = new Rook(PieceColour.BLACK, 1);

        for (int i = 0; i <= 7; i++) {
            figures[i] = new Pawn(PieceColour.WHITE, 1 + i);
            figures[i + 8] = new Pawn(PieceColour.BLACK, 1 + i);
        }

        for (int i = 0; i <= 31; i++) {
            print(figures[i]);
        }

        AnsiConsole.systemUninstall();
    }

    private static void print(ChessPiece chessPiece) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;

        Point position = chessPiece.getPosition();

        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));

        print(x, y, chessPiece.getSymbol());
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
}
