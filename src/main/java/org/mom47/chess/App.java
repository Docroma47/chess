package org.mom47.chess;


import org.fusesource.jansi.Ansi;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.mom47.chess.controller.ChessController;
import org.mom47.chess.controller.FunController;
import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;

import java.io.IOException;

import static org.mom47.chess.controller.ChessController.Action.Enter;

public class App {
    private Chess chess;
    private ChessBashView chessBashView;
    private FunController funController;
    private ChessController chessController;

    public App() {
        chess = new Chess();
        chessBashView = new ChessBashView(chess);
        funController = new FunController(chess, chessBashView);
        chessController = new ChessController(chess, chessBashView);
    }

    public void run() {
        chessBashView.print();
    }
    public static void main(String[] args) throws IOException {

        KeyMap map = new KeyMap();
        map.bind(ChessController.Action.Up, "\033[A");
        map.bind(ChessController.Action.Left, "\033[D");
        map.bind(ChessController.Action.Right, "\033[C");
        map.bind(ChessController.Action.Down, "\033[B");
        map.bind(ChessController.Action.Enter, "\r");
        map.bind(ChessController.Action.Escape, "\033");

        App app = new App();
        if (args.length > 0) {
            if (args[0].equals("random")) {
                app.funController.mixRandomlyChessPieces();
            } else if (args[0].equals("move")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                app.funController.move(file, rank);
            } else if (args[0].equals("snake")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                int mix = Integer.valueOf(args[3]);
                app.funController.moveSnake(file, rank, mix);
            } else if (args[0].equals("massacre")) {
                int mix = Integer.valueOf(args[1]);
                app.funController.massacre(mix);
            } else if (args[0].equals("tag")) {
                int mix = Integer.valueOf(args[1]);
                app.funController.tag(mix);
            } else if (args[0].equals("crazy-wander")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                int hidePiece = Integer.valueOf(args[3]);
                app.funController.crazyWander(file, rank, hidePiece);
            }
            app.run();
        } else {
            Terminal terminal = TerminalBuilder.terminal();
            terminal.enterRawMode();
            BindingReader reader = new BindingReader(terminal.reader());
            ChessController.Action action;
            app.chessBashView.print();
            do {
                action = (ChessController.Action) reader.readBinding(map);
                app.chessController.handleKey(action);
                app.chessBashView.print();
                Point cursor = app.chess.cursor;
                if (action == ChessController.Action.Enter && app.chess.getChessBoard().getPiece(cursor) != null) {
                    PieceColour colour = app.chess.getChessBoard().getPiece(cursor).getColor();
                    PieceType pieceType = app.chess.getChessBoard().getPiece(cursor).getPieceType();
                    String symbol = app.chess.getChessBoard().getPiece(cursor).getSymbol();
                    app.chess.selectedPiece = app.chess.getChessBoard().getPiece(cursor);
                    for (int i = 0; i <= app.chess.selectedPiece.getAvailablePaths().length - 1; i++) {
                        for (int j = 0; j <= app.chess.selectedPiece.getAvailablePaths()[i].length - 1; j++) {
                            int rank1 = app.chess.selectedPiece.getAvailablePaths()[i][j].getRank();
                            int file1 = app.chess.selectedPiece.getAvailablePaths()[i][j].getFile();
                            int rank = 16 - (rank1 * 2);
                            int file = 5 + (file1 * 4);
                            System.out.println(Ansi.ansi().cursor(rank, file).fg(Ansi.Color.RED).a("▒"));
                        }
                    }
                    System.out.println(Ansi.ansi().cursor(21, 0).fg(Ansi.Color.WHITE).a(colour + " ").a(pieceType + " ").a(symbol + " "));
                } else if (action == Enter && app.chess.getChessBoard().getPiece(cursor) == null) {
                    System.out.println(Ansi.ansi().cursor(21, 0).fg(Ansi.Color.WHITE).a("Empty cell"));
                }
                System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
            } while (action != ChessController.Action.Escape);
        }
    }
}
