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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


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
            if (args[0].equals("single-player-mode")) {
                app.chess.setSinglePlayerMode(true);
            }

        }

        File file = new File(args[0]);
        if(file.createNewFile()){
            System.out.println(args[0] + "File create");
            Terminal terminal = TerminalBuilder.terminal();
            terminal.enterRawMode();
            BindingReader reader = new BindingReader(terminal.reader());
            ChessController.Action action;
            app.chessBashView.print();
            do {
                app.chess.setSinglePlayerMode(true);
                action = (ChessController.Action) reader.readBinding(map);
                app.chessController.handleKey(action);
                app.chessBashView.print();
                action = app.chessController.gameEnd(action);
                System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
                if (action == ChessController.Action.Save) {
                    toJSON(app, file);
                    break;
                }
            } while (action != ChessController.Action.Exit);
        } else {
            System.out.println(args[0] + "file not created");
            FileReader reader = new FileReader(file);
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            reader.close();
        }
    }

    private static void toJSON(Object object, File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, object);
        System.out.println(Ansi.ansi().cursor(22, 0).fg(Ansi.Color.WHITE).a("JSON Save"));
    }
}
