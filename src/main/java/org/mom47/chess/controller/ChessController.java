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
        ChessPiece chessPiece = chess.selectedPiece;
        if (chessPiece == null) {
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
            }
        } else {
            int rank = chess.cursor.getRank();
            int file = chess.cursor.getFile();
            int length = chessPiece.getAvailablePaths(chess.getChessBoard()).length;
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chessPiece.getAvailablePaths(chessBoard);
            for (int i = 0; i <= length - 1; i++) {
                if (availablePaths[i] != null) {
                    chess.selectedPath = availablePaths[i];
                    chess.cursor = chess.selectedPath[0];
                    break;
                }
            }

            if (action == Up) {
                int length1 = chess.selectedPath.length;
                for (int i = 0; i <= length1 - 1; i++) {
                    if (chess.selectedPath[i].equals(chess.cursor)) {
                        if (i + 1 <= length1 - 1) {
                            chess.cursor = chess.selectedPath[i + 1];
                            break;
                        }
                    }
                }

            } else if (action == Left && file > 0) {

            } else if (action == Right && file < 7) {

            } else if (action == Down && rank > 0) {

            }
        }

        Point cursor = chess.cursor;
        if (action == ChessController.Action.Enter ) {
            if (chessPiece != null) {
                chess.getChessBoard().move(chessPiece.getPosition(), cursor);
                chess.selectedPiece = null;
            } else {
                chess.selectedPiece = chess.getChessBoard().getPiece(cursor);
            }
        }
    }
}
