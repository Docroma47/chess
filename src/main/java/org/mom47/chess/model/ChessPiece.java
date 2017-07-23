package org.mom47.chess.model;


import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.King;
import org.mom47.chess.model.PieceColour;
import org.mom47.chess.model.Point;
import org.mom47.chess.model.Queen;
import org.mom47.chess.model.Bishop;
import org.mom47.chess.model.Pawn;
import org.mom47.chess.model.Knight;
import org.mom47.chess.model.Rook;

public class ChessPiece {
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
        ChessPiece chessPiece = new ChessPiece();
        printChessDesk(1, 1);

        Point point = new Point(5, 1);
        King whiteking = new King();
        whiteking.setPosition(point);
        whiteking.setColor(PieceColour.WHITE);
        whiteking.setSymbol(WHITE_KING);
        printKing(whiteking);

        Queen whitequeen = new Queen();
        whitequeen.setPosition(new Point(4, 1));
        whitequeen.setSymbol(WHITE_QUEEN);
        printQueen(whitequeen);

        Point point1 = new Point(6, 1);
        Bishop whitebishop = new Bishop();
        whitebishop.setPosition(point1);
        whitebishop.setColor(PieceColour.WHITE);
        whitebishop.setSymbol(WHITE_BISHOP);
        printBishop(whitebishop);

        Point point2 = new Point(3, 1);
        Bishop whitebishop1 = new Bishop();
        whitebishop1.setPosition(point2);
        whitebishop1.setColor(PieceColour.WHITE);
        whitebishop1.setSymbol(WHITE_BISHOP);
        printBishop(whitebishop1);

        Point point3 = new Point(2, 1);
        Knight whiteknight = new Knight();
        whiteknight.setPosition(point3);
        whiteknight.setColor(PieceColour.WHITE);
        whiteknight.setSymbol(WHITE_KNIGHT);
        printKnight(whiteknight);

        Point point4 = new Point(7, 1);
        Knight whiteknight1 = new Knight();
        whiteknight1.setPosition(point4);
        whiteknight1.setColor(PieceColour.WHITE);
        whiteknight1.setSymbol(WHITE_KNIGHT);
        printKnight(whiteknight1);

        Point point5 = new Point(1, 1);
        Rook whiterook = new Rook();
        whiterook.setPosition(point5);
        whiterook.setColor(PieceColour.WHITE);
        whiterook.setSymbol(WHITE_ROOK);
        printRook(whiterook);

        Point point6 = new Point(8, 1);
        Rook whiterook1 = new Rook();
        whiterook1.setPosition(point6);
        whiterook1.setColor(PieceColour.WHITE);
        whiterook1.setSymbol(WHITE_ROOK);
        printRook(whiterook1);

        Point point7 = new Point(8, 2);
        Pawn whitepawn = new Pawn();
        whitepawn.setPosition(point7);
        whitepawn.setColor(PieceColour.WHITE);
        whitepawn.setSymbol(WHITE_PAWN);
        printPawn(whitepawn);

        Point point8 = new Point(7, 2);
        Pawn whitepawn1 = new Pawn();
        whitepawn1.setPosition(point8);
        whitepawn1.setColor(PieceColour.WHITE);
        whitepawn1.setSymbol(WHITE_PAWN);
        printPawn(whitepawn1);

        Point point9 = new Point(6, 2);
        Pawn whitepawn2 = new Pawn();
        whitepawn2.setPosition(point9);
        whitepawn2.setColor(PieceColour.WHITE);
        whitepawn2.setSymbol(WHITE_PAWN);
        printPawn(whitepawn2);

        Point point10 = new Point(5, 2);
        Pawn whitepawn3 = new Pawn();
        whitepawn3.setPosition(point10);
        whitepawn3.setColor(PieceColour.WHITE);
        whitepawn3.setSymbol(WHITE_PAWN);
        printPawn(whitepawn3);

        Point point11 = new Point(4, 2);
        Pawn whitepawn4 = new Pawn();
        whitepawn4.setPosition(point11);
        whitepawn4.setColor(PieceColour.WHITE);
        whitepawn4.setSymbol(WHITE_PAWN);
        printPawn(whitepawn4);

        Point point12 = new Point(3, 2);
        Pawn whitepawn5 = new Pawn();
        whitepawn5.setPosition(point12);
        whitepawn5.setColor(PieceColour.WHITE);
        whitepawn5.setSymbol(WHITE_PAWN);
        printPawn(whitepawn5);

        Point point13 = new Point(2, 2);
        Pawn whitepawn6 = new Pawn();
        whitepawn6.setPosition(point13);
        whitepawn6.setColor(PieceColour.WHITE);
        whitepawn6.setSymbol(WHITE_PAWN);
        printPawn(whitepawn6);

        Point point14 = new Point(1, 2);
        Pawn whitepawn7 = new Pawn();
        whitepawn7.setPosition(point14);
        whitepawn7.setColor(PieceColour.WHITE);
        whitepawn7.setSymbol(WHITE_PAWN);
        printPawn(whitepawn7);

        Point point29 = new Point(5, 8);
        King blackking = new King();
        blackking.setPosition(point29);
        blackking.setColor(PieceColour.BLACK);
        blackking.setSymbol(BLACK_KING);
        printKing(blackking);

        Queen balckqueen = new Queen();
        balckqueen.setPosition(new Point(4, 8));
        balckqueen.setSymbol(BLACK_QUEEN);
        printQueen(balckqueen);

        Point point28 = new Point(6, 8);
        Bishop blackbishop = new Bishop();
        blackbishop.setPosition(point28);
        blackbishop.setColor(PieceColour.BLACK);
        blackbishop.setSymbol(BLACK_BISHOP);
        printBishop(blackbishop);

        Point point27 = new Point(3, 8);
        Bishop blackbishop1 = new Bishop();
        blackbishop1.setPosition(point27);
        blackbishop1.setColor(PieceColour.BLACK);
        blackbishop1.setSymbol(BLACK_BISHOP);
        printBishop(blackbishop1);

        Point point26 = new Point(2, 8);
        Knight blackknight1 = new Knight();
        blackknight1.setPosition(point26);
        blackknight1.setColor(PieceColour.BLACK);
        blackknight1.setSymbol(BLACK_KNIGHT);
        printKnight(blackknight1);

        Point point25 = new Point(7, 8);
        Knight blackknight = new Knight();
        blackknight.setPosition(point25);
        blackknight.setColor(PieceColour.BLACK);
        blackknight.setSymbol(BLACK_KNIGHT);
        printKnight(blackknight);

        Point point24 = new Point(1, 8);
        Rook blackrook = new Rook();
        blackrook.setPosition(point24);
        blackrook.setColor(PieceColour.BLACK);
        blackrook.setSymbol(BLACK_ROOK);
        printRook(blackrook);

        Point point23 = new Point(8, 8);
        Rook blackrook1 = new Rook();
        blackrook1.setPosition(point23);
        blackrook1.setColor(PieceColour.BLACK);
        blackrook1.setSymbol(BLACK_ROOK);
        printRook(blackrook1);

        Point point22 = new Point(8, 7);
        Pawn blackpawn7 = new Pawn();
        blackpawn7.setPosition(point22);
        blackpawn7.setColor(PieceColour.BLACK);
        blackpawn7.setSymbol(BLACK_PAWN);
        printPawn(blackpawn7);

        Point point21 = new Point(7, 7);
        Pawn blackpawn6 = new Pawn();
        blackpawn6.setPosition(point21);
        blackpawn6.setColor(PieceColour.BLACK);
        blackpawn6.setSymbol(BLACK_PAWN);
        printPawn(blackpawn6);

        Point point20 = new Point(6, 7);
        Pawn blackpawn5 = new Pawn();
        blackpawn5.setPosition(point20);
        blackpawn5.setColor(PieceColour.BLACK);
        blackpawn5.setSymbol(BLACK_PAWN);
        printPawn(blackpawn5);

        Point point19 = new Point(5, 7);
        Pawn blackpawn4 = new Pawn();
        blackpawn4.setPosition(point19);
        blackpawn4.setColor(PieceColour.BLACK);
        blackpawn4.setSymbol(BLACK_PAWN);
        printPawn(blackpawn4);

        Point point18 = new Point(4, 7);
        Pawn blackpawn3 = new Pawn();
        blackpawn3.setPosition(point18);
        blackpawn3.setColor(PieceColour.BLACK);
        blackpawn3.setSymbol(BLACK_PAWN);
        printPawn(blackpawn3);

        Point point17 = new Point(3, 7);
        Pawn blackpawn2 = new Pawn();
        blackpawn2.setPosition(point17);
        blackpawn2.setColor(PieceColour.BLACK);
        blackpawn2.setSymbol(BLACK_PAWN);
        printPawn(blackpawn2);

        Point point16 = new Point(2, 7);
        Pawn blackpawn1 = new Pawn();
        blackpawn1.setPosition(point16);
        blackpawn1.setColor(PieceColour.BLACK);
        blackpawn1.setSymbol(BLACK_PAWN);
        printPawn(blackpawn1);

        Point point15 = new Point(1, 7);
        Pawn blackpawn = new Pawn();
        blackpawn.setPosition(point15);
        blackpawn.setColor(PieceColour.BLACK);
        blackpawn.setSymbol(BLACK_PAWN);
        printPawn(blackpawn);


        AnsiConsole.systemUninstall();
    }
    private  static  void printPawn(Pawn pawn) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;
        Point position = pawn.getPosition();
        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));
    }

    private  static  void printKnight(Knight knight) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;
        Point position = knight.getPosition();
        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));

    }

    private  static  void printRook(Rook rook) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;
        Point position = rook.getPosition();
        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));
    }

    private  static  void printBishop(Bishop bishop) {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 1;
        int bardInitialPointY = 0;
        int boardHeight = 18;
        Point position = bishop.getPosition();
        int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
        int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));
    }

}