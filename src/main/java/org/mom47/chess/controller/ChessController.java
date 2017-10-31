package org.mom47.chess.controller;

import org.fusesource.jansi.Ansi;
import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;

import java.util.Random;

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
        if (chess.selectedPiece == null) {
            int rank = chess.cursor.getRank();
            int file = chess.cursor.getFile();
            if (action == Up && rank < 7) {
                chess.cursor = chess.cursor.getUp();
            } else if (action == Left && file > 0) {
                chess.cursor = chess.cursor.getLeft();
            } else if (action == Right && file < 7) {
                chess.cursor = chess.cursor.getRight();
            } else if (action == Down && rank > 0) {
                chess.cursor = chess.cursor.getDown();
            } else if (action == ChessController.Action.Enter) {
                chess.selectedPiece = chess.getChessBoard().getPiece(chess.cursor);
                int length = chess.selectedPiece.getAvailablePaths(chess.getChessBoard()).length;
                ChessBoard chessBoard = chess.getChessBoard();
                Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
                for (int i = 0; i <= length - 1; i++) {
                    if (availablePaths[i] != null) {
                        chess.selectedPath = availablePaths[i];
                        chess.cursor = chess.selectedPath[0];
                        break;
                    }
                }
            }

        } else {
            int length1 = chess.selectedPath.length;
            if (action == Up) {
                for (int i = 0; i <= length1 - 1; i++) {
                    if (chess.selectedPath[i].equals(chess.cursor)) {
                        if (i + 1 <= length1 - 1) {
                            chess.cursor = chess.selectedPath[i + 1];
                            break;
                        }
                    }
                }
            } else if (action == Down) {
                for (int i = 0; i <= length1 - 1; i++) {
                    if (chess.selectedPath[i].equals(chess.cursor)) {
                        if (i + 1 <= length1 - 1) {
                            chess.cursor = chess.selectedPath[i - 1];
                            break;
                        }
                    }
                }
            } else if (action == ChessController.Action.Enter) {
                chess.getChessBoard().move(chess.selectedPiece.getPosition(), chess.cursor);
                chess.selectedPiece = null;
            }
        }

    }
}
