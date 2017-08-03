package org.mom47.chess.model.view;


import org.fusesource.jansi.Ansi;
import org.mom47.chess.model.*;

public class ChessBashView {
    private Chess chess = new Chess();

    public ChessBashView(Chess chess) {
    }

    public void prints() {
        printChessBoard(1, 1);
        printChessPieces();
    }

    private void printChessBoard(int x, int y) {
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

    private void printChessPieces() {
        ChessPiece[] figures = new ChessPiece[32];

        int j = 0;

        for (PieceColour color : PieceColour.values()) {
            figures[16 + j * 8] = new King(color, 5);
            figures[17 + j * 8] = new Queen(color, 4);
            figures[18 + j * 8] = new Bishop(color, 6);
            figures[19 + j * 8] = new Bishop(color, 3);
            figures[20 + j * 8] = new Knight(color, 7);
            figures[21 + j * 8] = new Knight(color, 2);
            figures[22 + j * 8] = new Rook(color, 8);
            figures[23 + j * 8] = new Rook(color, 1);
            j++;
        }

        for (int i = 0; i <= 7; i++) {
            figures[i] = new Pawn(PieceColour.WHITE, 1 + i);
            figures[i + 8] = new Pawn(PieceColour.BLACK,1 + i);
        }

        for (int i = 0; i <= 31; i++) {
            print(figures[i]);
        }
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

    private static void print(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }
}
