package org.mom47.chess.controller;

import org.fusesource.jansi.Ansi;
import org.mom47.chess.model.Chess;
import org.mom47.chess.model.Point;
import org.mom47.chess.view.ChessBashView;

import static org.mom47.chess.controller.ChessController.Action.*;

public class ChessController {

    public enum Action {
        Up,
        Left,
        Right,
        Down,
        Enter,
        Escape
    }

    private Chess chess;
    private ChessBashView chessBashView;

    public ChessController(Chess chess, ChessBashView chessBashView) {
        this.chess = chess;
        this.chessBashView = chessBashView;
    }

    public void handleKey(Action action) {
        if (action == Up && chess.cursor.getRank() < 7) {
            chess.cursor = chess.cursor.getUp();
        } else if (action == Left && chess.cursor.getFile() > 0) {
            chess.cursor = chess.cursor.getLeft();
        } else if (action == Right && chess.cursor.getFile() < 7) {
            chess.cursor = chess.cursor.getRight();
        } else if (action == Down && chess.cursor.getRank() > 0) {
            chess.cursor = chess.cursor.getDown();
        }
        System.out.println(Ansi.ansi().cursor(20, 0).fg(Ansi.Color.WHITE).a(action));
    }

}
