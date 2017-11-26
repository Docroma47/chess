package org.mom47.chess;


import com.fasterxml.jackson.databind.ObjectMapper;
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
    private Chess chess;
    private ChessBashView chessBashView;
    private ChessController chessController;

    public App() {
        chess = new Chess();
        chessBashView = new ChessBashView(chess);
        chessController = new ChessController(chess, chessBashView);
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        CheeJSON cheeJSON = new CheeJSON();
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
        map.bind(ChessController.Action.Downloading, "d");
        if (args.length > 0) {
            File file = new File(args[0]);
            if (args[0].equals("single-player-mode")) {
                app.chess.setSinglePlayerMode(true);
            } else if (args[0].equals(file.getAbsolutePath())) {
                Terminal terminal = TerminalBuilder.terminal();
                terminal.enterRawMode();
                BindingReader reader = new BindingReader(terminal.reader());
                ChessController.Action action;
                if(file.createNewFile()){
                    do {
                        app.chessBashView.print();
                        action = (ChessController.Action) reader.readBinding(map);
                        app.chessController.handleKey(action, file);
                        app.chessBashView.print();
                        action = app.chessController.gameEnd(action);
                        System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
                    } while (action != ChessController.Action.Exit);
                } else {
                    System.out.println(app.chessController.toJavaObject(file));
                }
            }
        }
    }

}
