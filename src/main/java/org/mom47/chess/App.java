package org.mom47.chess;


import org.fusesource.jansi.Ansi;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.mom47.chess.controller.ChessController;
import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;

import java.io.*;


public class App {
    private ChessBashView chessBashView;
    private ChessController chessController;

    public static void main(String[] args) throws IOException {
        App app = new App();
        KeyMap map = new KeyMap();

        map.bind(ChessController.Action.Up, "\033[A");
        map.bind(ChessController.Action.Left, "\033[D");
        map.bind(ChessController.Action.Right, "\033[C");
        map.bind(ChessController.Action.Down, "\033[B");
        map.bind(ChessController.Action.Enter, "\r");
        map.bind(ChessController.Action.Escape, "\033");
        map.bind(ChessController.Action.Exit, "q");
        map.bind(ChessController.Action.Coup, "u");
        map.bind(ChessController.Action.Save, "s");
        map.bind(ChessController.Action.Load, "d");
        map.bind(ChessController.Action.Reset, "r");

        app.init(args);

        File file;
        if (args.length > 0) {
             file = new File(args[0]);
        } else {
            file = new File("chess.json");
        }

        Terminal terminal = TerminalBuilder.terminal();
        terminal.enterRawMode();
        BindingReader reader = new BindingReader(terminal.reader());
        ChessController.Action action;
        if(file.createNewFile()){
            do {
                app.chessBashView.print();
                action = (ChessController.Action) reader.readBinding(map);
                app.chessController.handleKey(action, file);
                if (action == ChessController.Action.Load || action == ChessController.Action.Reset) {
                    app.replacementModel(file);
                }
                app.chessBashView.print();
                action = app.chessController.gameEnd(action);
                System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
            } while (action != ChessController.Action.Exit);
        } else {
            action = ChessController.Action.Load;
            app.chessController.handleKey(action, file);
            app.replacementModel(file);
            app.chessBashView.print();
            do {
                action = (ChessController.Action) reader.readBinding(map);
                app.chessController.handleKey(action, file);
                if (action == ChessController.Action.Load || action == ChessController.Action.Reset) {
                    app.replacementModel(file);
                }
                app.chessBashView.print();
                action = app.chessController.gameEnd(action);
                System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
            } while (action != ChessController.Action.Exit);
        }
    }

    private void init(String[] args) throws IOException {
        File fileName;
        if (args.length == 0) {
            fileName = new File("chess.json");
        } else {
            fileName = new File(args[0]);
        }
        Chess chess = ChessController.loadModel(fileName);
        chessBashView = new ChessBashView(chess);
        chessController = new ChessController(chess, chessBashView);
    }

    public void replacementModel(File file) throws IOException {
        Chess chess = ChessController.loadModel(file);
        chessBashView = new ChessBashView(chess);
        for (int i = 0; i < chess.getChessPieces().length; i++) {
            chessBashView.chess.getChessPieces()[i] = chess.getChessBoard().getChessPieces()[i];
            chessBashView.chess.getChessBoard().getChessPieces()[i] = chess.getChessBoard().getChessPieces()[i];
        }
        chessController = new ChessController(chess, chessBashView);
    }

}
