package org.mom47.chess;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.*;

public class App {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        printChessDesk(1, 1);

        King whiteking = new King(PieceColour.WHITE, 5);
        print(whiteking);

        Queen whitequeen = new Queen(PieceColour.WHITE, 4);
        print(whitequeen);

        Bishop whitebishop = new Bishop(PieceColour.WHITE, 6);
        print(whitebishop);

        Bishop whitebishop1 = new Bishop(PieceColour.WHITE, 3);
        print(whitebishop1);

        Knight whiteknight = new Knight(PieceColour.WHITE, 7);
        print(whiteknight);

        Knight whiteknight1 = new Knight(PieceColour.WHITE, 2);
        print(whiteknight1);

        Rook whiterook = new Rook(PieceColour.WHITE, 8);
        print(whiterook);

        Rook whiterook1 = new Rook(PieceColour.WHITE, 1);
        print(whiterook1);

        Pawn whitepawn = new Pawn(PieceColour.WHITE, 1);
        print(whitepawn);

        Pawn whitepawn1 = new Pawn(PieceColour.WHITE,2);
        print(whitepawn1);

        Pawn whitepawn2 = new Pawn(PieceColour.WHITE, 3);
        print(whitepawn2);

        Pawn whitepawn3 = new Pawn(PieceColour.WHITE, 4);
        print(whitepawn3);

        Pawn whitepawn4 = new Pawn(PieceColour.WHITE, 5);
        print(whitepawn4);

        Pawn whitepawn5 = new Pawn(PieceColour.WHITE, 6);
        print(whitepawn5);

        Pawn whitepawn6 = new Pawn(PieceColour.WHITE, 7);
        print(whitepawn6);

        Pawn whitepawn7 = new Pawn(PieceColour.WHITE, 8);
        print(whitepawn7);

        King blackking = new King(PieceColour.BLACK, 5);
        print(blackking);

        Queen balckqueen = new Queen(PieceColour.BLACK, 4);
        print(balckqueen);

        Bishop blackbishop = new Bishop(PieceColour.BLACK, 6);
        print(blackbishop);

        Bishop blackbishop1 = new Bishop(PieceColour.BLACK, 3);
        print(blackbishop1);

        Knight blackknight1 = new Knight(PieceColour.BLACK, 7);
        print(blackknight1);

        Knight blackknight = new Knight(PieceColour.BLACK, 2);
        print(blackknight);

        Rook blackrook = new Rook(PieceColour.BLACK, 8);
        print(blackrook);

        Rook blackrook1 = new Rook(PieceColour.BLACK, 1);
        print(blackrook1);

        Pawn blackpawn7 = new Pawn(PieceColour.BLACK, 1);
        print(blackpawn7);

        Pawn blackpawn6 = new Pawn(PieceColour.BLACK, 2);
        print(blackpawn6);

        Pawn blackpawn5 = new Pawn(PieceColour.BLACK, 3);
        print(blackpawn5);

        Pawn blackpawn4 = new Pawn(PieceColour.BLACK, 4);
        print(blackpawn4);

        Pawn blackpawn3 = new Pawn(PieceColour.BLACK, 5);
        print(blackpawn3);

        Pawn blackpawn2 = new Pawn(PieceColour.BLACK, 6);
        print(blackpawn2);

        Pawn blackpawn1 = new Pawn(PieceColour.BLACK, 7);
        print(blackpawn1);

        Pawn blackpawn = new Pawn(PieceColour.BLACK, 8);
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
