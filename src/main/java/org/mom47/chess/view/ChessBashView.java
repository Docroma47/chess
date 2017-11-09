package org.mom47.chess.view;


import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.mom47.chess.model.*;


public class ChessBashView {
    private Chess chess;

    public ChessBashView(Chess chess) {
        AnsiConsole.systemUninstall();
        this.chess = chess;
    }

    public void print() {
        System.out.println(Ansi.ansi().reset().eraseScreen().toString());

        printChessBoard();
        printChessPieces();

        System.out.println(Ansi.ansi().cursor(30, 0).a("").reset().toString());
        printSelectedChessPiece();
        printSelectedChessPieceAvailablePaths();
        printСursor();

    }

    private void printChessPieces() {
        for (int i = 0; i <= 31; i++) {
            print(chess.getChessPieces()[i]);
        }
    }

    private void print(ChessPiece chessPiece) {
        if (chessPiece.getIsCaptured() == false) {
            int horizontalNumberOfSymbolsPerCell = 4;
            int verticalNumberOfSymbolsPerCell = 2;
            int boardInitialPointX = 5;
            int bardInitialPointY = 0;
            int boardHeight = 16;

            Point position = chessPiece.getPosition();
            int x = boardInitialPointX + (position.getFile() * horizontalNumberOfSymbolsPerCell);
            int y = bardInitialPointY + (boardHeight - (position.getRank() * verticalNumberOfSymbolsPerCell));

            if (chess.side != PieceColour.WHITE) {
                print(38 - x, 19 - y, chessPiece.getSymbol());
            } else {
                print(x, 1 + y, chessPiece.getSymbol());
            }
        }
    }

    private void printChessBoard() {
        if (chess.side != PieceColour.WHITE) {
            printBlackSide();
        } else {
            printWhiteSide();
        }
    }

    private void printBlackSide() {
        int x = 1;
        int y = 1;
        print(x, y,          "    H   G   F   E   D   C   B   A");
        print(x, y + 1,      "  ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗  ");
        print(x, y + 2,      "  ║   │   │   │   │   │   │   │   ║ 1");
        print(x, y + 3,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 4,      "  ║   │   │   │   │   │   │   │   ║ 2");
        print(x, y + 5,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 6,      "  ║   │   │   │   │   │   │   │   ║ 3");
        print(x, y + 7,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 8,      "  ║   │   │   │   │   │   │   │   ║ 4");
        print(x, y + 9,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 10,     "  ║   │   │   │   │   │   │   │   ║ 5");
        print(x, y + 11,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 12,     "  ║   │   │   │   │   │   │   │   ║ 6");
        print(x, y + 13,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 14,     "  ║   │   │   │   │   │   │   │   ║ 7");
        print(x, y + 15,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢  ");
        print(x, y + 16,     "  ║   │   │   │   │   │   │   │   ║ 8");
        print(x, y + 17,     "  ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝  ");
    }

    private void printWhiteSide() {
        int x = 1;
        int y = 1;
        print(x, y,          "                                 ");
        print(x, y + 1,      "  ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗");
        print(x, y + 2,      "8 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 3,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 4,      "7 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 5,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 6,      "6 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 7,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 8,      "5 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 9,      "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 10,     "4 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 11,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 12,     "3 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 13,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 14,     "2 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 15,     "  ╟───┼───┼───┼───┼───┼───┼───┼───╢");
        print(x, y + 16,     "1 ║   │   │   │   │   │   │   │   ║");
        print(x, y + 17,     "  ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝");
        print(x, y + 18,     "    A   B   C   D   E   F   G   H");
    }


    private void printSelectedChessPiece() {
        ChessPiece selectedPiece = chess.selectedPiece;
        if (selectedPiece != null) {
            if (selectedPiece.getPosition() != null) {
                PieceColour colour = selectedPiece.getColor();
                PieceType pieceType = selectedPiece.getPieceType();
                String symbol = selectedPiece.getSymbol();
                int rankSelectPiece = selectedPiece.getPosition().getRank();
                int fileSelectPiece = selectedPiece.getPosition().getFile();
                rankSelectPiece = 16 - (rankSelectPiece * 2);
                fileSelectPiece = 5 + (fileSelectPiece * 4);
                print(fileSelectPiece, rankSelectPiece, selectedPiece.getSymbol(), Ansi.Color.YELLOW);
                System.out.println(Ansi.ansi().cursor(21, 0).fg(Ansi.Color.WHITE).a(colour + " ")
                        .a(pieceType + " ").a(symbol + " "));
            }
        }
    }

    private void printSelectedChessPieceAvailablePaths() {
        ChessPiece selectedPiece = chess.selectedPiece;
        if (selectedPiece != null) {
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
                        print(file, rank, symbolAvailablePaths, Ansi.Color.RED);
                    } else if (chessPiece == null) {
                        print(file, rank, "▒", Ansi.Color.BLUE);
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
            print(file, rank, symbolAvailablePaths, Ansi.Color.YELLOW);
        } else if (chessPiece == null) {
            print(file, rank, "▒",Ansi.Color.YELLOW);
        }
    }
    private void print(int x, int y, String text, Ansi.Color colour) {
        if (chess.side != PieceColour.WHITE) {
            System.out.println(Ansi.ansi().cursor(19 - y, 38 - x).fg(colour).a(text));
        } else {
            System.out.println(Ansi.ansi().cursor(1 + y, x).fg(colour).a(text));
        }
    }

    private static void print(int x, int y, String text) {
        Ansi ansi = Ansi.ansi();
        ansi.cursor(y, x).fg(Ansi.Color.WHITE).a(text);
        System.out.println(ansi);
    }
}
