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
        Escape,
        Exit
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
                    if (availablePaths[i].length != 0) {
                        chess.selectedPath = i;
                        chess.cursor = availablePaths[i][0];
                        break;
                    }
                }
            }

        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            if (action == Up) {
                for (int i = 0; i <= availablePaths[chess.selectedPath].length - 1; i++) {
                    if (availablePaths[chess.selectedPath][i].equals(chess.cursor)) {
                        if (i + 1 <= availablePaths[chess.selectedPath].length - 1) {
                            chess.cursor = availablePaths[chess.selectedPath][i + 1];
                            break;
                        }
                    }
                }
            } else if (action == Left) {
                if (chess.selectedPath >= 0) {
                    if (chess.selectedPath == 0) {
                        chess.selectedPath = availablePaths.length - 1;
                        if (availablePaths[chess.selectedPath].length == 0) {
                            for (int i = chess.selectedPath; i >= 0; i--) {
                                if (availablePaths[i].length != 0) {
                                    chess.selectedPath = i;
                                    chess.cursor = availablePaths[i][0];
                                    break;
                                }
                            }
                        } else {
                            chess.cursor = availablePaths[chess.selectedPath][0];
                        }
                    } else {
                        chess.selectedPath = chess.selectedPath - 1;
                        if (availablePaths[chess.selectedPath].length == 0) {
                            for (int i = chess.selectedPath; i >= 0; i--) {
                                if (availablePaths[i].length != 0) {
                                    chess.selectedPath = i;
                                    chess.cursor = availablePaths[i][0];
                                    break;
                                } else if (chess.selectedPath == 0) {
                                    chess.selectedPath =availablePaths.length;
                                    i = availablePaths.length;
                                }
                            }
                        } else {
                            chess.cursor = availablePaths[chess.selectedPath][0];
                        }
                    }
                }
            } else if (action == Right) {
                if (chess.selectedPath <= availablePaths.length - 1) {
                    if (chess.selectedPath == availablePaths.length - 1) {
                        chess.selectedPath = 0;
                        if (availablePaths[chess.selectedPath].length == 0) {
                            for (int i = chess.selectedPath; i <= availablePaths.length - 1; i++) {
                                if (availablePaths[i].length != 0) {
                                    chess.selectedPath = i;
                                    chess.cursor = availablePaths[i][0];
                                    break;
                                }
                            }
                        } else {
                            chess.cursor = availablePaths[chess.selectedPath][0];
                        }
                    } else {
                        chess.selectedPath = chess.selectedPath + 1;
                        if (availablePaths[chess.selectedPath].length == 0) {
                            for (int i = chess.selectedPath; i <= availablePaths.length - 1; i++) {
                                if (availablePaths[i].length != 0) {
                                    chess.selectedPath = i;
                                    chess.cursor = availablePaths[i][0];
                                    break;
                                } else if (chess.selectedPath == availablePaths.length - 1) {
                                    chess.selectedPath = - 1;
                                    i = - 1;
                                }
                            }
                        } else {
                            chess.cursor = availablePaths[chess.selectedPath][0];
                        }
                    }
                }
            } else if (action == Down) {
                for (int i = 0; i <= availablePaths[chess.selectedPath].length - 1; i++) {
                    if (availablePaths[chess.selectedPath][i].equals(chess.cursor)) {
                        if (i - 1 >= 0) {
                            chess.cursor = availablePaths[chess.selectedPath][i - 1];
                            break;
                        }
                    }
                }
            } else if (action == ChessController.Action.Enter) {
                if (chessBoard.getPiece(chess.cursor) != null) {
                    if (chess.selectedPiece.getColor() != chessBoard.getPiece(chess.cursor).getColor()) {
                        chessBoard.getPiece(chess.cursor).setIsCaptured(false);
                        chessBoard.remove(chess.cursor);
                        chess.getChessBoard().move(chess.selectedPiece.getPosition(), chess.cursor);
                        chess.selectedPiece = null;
                    }
                } else {
                    chess.getChessBoard().move(chess.selectedPiece.getPosition(), chess.cursor);
                    chess.selectedPiece = null;
                }
            } else if (action == Action.Escape) {
                chess.selectedPiece = null;
            }
        }
    }
}
