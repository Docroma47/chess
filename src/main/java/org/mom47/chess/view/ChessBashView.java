package org.mom47.chess.view;


import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.*;


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
        printSelectedChessPiece();
        printСursor();

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

    private void printSelectedChessPiece() {
        ChessPiece selectedPiece = chess.selectedPiece;
        if (selectedPiece != null) {
            if (selectedPiece.getPosition() != null) {
                PieceColour colour = selectedPiece.getColor();
                PieceType pieceType = selectedPiece.getPieceType();
                String symbol = selectedPiece.getSymbol();
                Point[][] availablePaths = selectedPiece.getAvailablePaths(chess.getChessBoard());
                for (int i = 0; i <= availablePaths.length - 1; i++) {
                    for (int j = 0; j <= availablePaths[i].length - 1; j++) {
                        int rank1 = availablePaths[i][j].getRank();
                        int file1 = availablePaths[i][j].getFile();
                        int rank = 16 - (rank1 * 2);
                        int file = 5 + (file1 * 4);
                        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file1, rank1));
                        if (chessPiece != null && selectedPiece.getColor() != chessPiece.getColor()) {
                            String symbolAvailablePaths = chessPiece.getSymbol();
                            System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color. RED).a(symbolAvailablePaths));
                        } else if(chessPiece == null) {
                            System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color.BLUE).a("▒"));
                        }
                        int rankSelectPiece = selectedPiece.getPosition().getRank();
                        int fileSelectPiece = selectedPiece.getPosition().getFile();
                        rankSelectPiece = 16 - (rankSelectPiece * 2);
                        fileSelectPiece = 5 + (fileSelectPiece * 4);
                        System.out.println(Ansi.ansi().cursor(rankSelectPiece, fileSelectPiece).fg(Ansi.Color.YELLOW).a(selectedPiece.getSymbol()));
                        System.out.println(Ansi.ansi().cursor(21, 0).fg(Ansi.Color.WHITE).a(colour + " ").a(pieceType + " ").a(symbol + " "));
                    }
                }
            }
        }
    }

    private void printСursor() {
        int horizontalNumberOfSymbolsPerCell = 4;
        int verticalNumberOfSymbolsPerCell = 2;
        int boardInitialPointX = 5;
        int bardInitialPointY = 0;
        int boardHeight = 16;
        Point cursor = chess.cursor;
        int rank = bardInitialPointY + (boardHeight - (cursor.getRank() * verticalNumberOfSymbolsPerCell));
        int file = boardInitialPointX + (cursor.getFile() * horizontalNumberOfSymbolsPerCell);
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(cursor.getFile(), cursor.getRank()));
        if (chessPiece != null) {
            String symbolAvailablePaths = chessPiece.getSymbol();
            System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color.YELLOW).a(symbolAvailablePaths));
        } else if (chessPiece == null) {
            System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color.YELLOW).a("▒"));
        }
    }

    private static void print(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }
}
