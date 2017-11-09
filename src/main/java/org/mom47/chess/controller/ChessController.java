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
        Exit,
        Coup
    }

    private Chess chess;
    private ChessBashView chessBashView;

    public ChessController(Chess chess, ChessBashView chessBashView) {
        this.chess = chess;
        this.chessBashView = chessBashView;
    }

    public void handleKey(Action action) {
        action = translateAction(action);
        handleArrowKeys(action);
        handleKeyEnter(action);
        handleKeyCoup(action);
        handleKeyEscape(action);

    }

    private void handleArrowKeys(Action action) {
        int rank = chess.cursor.getRank();
        int file = chess.cursor.getFile();

        if (action == Up && rank < 7) {
            handleKeyUp();
        } else if (action == Left && file > 0) {
            handleKeyLeft();
        } else if (action == Right && file < 7) {
            handleKeyRight();
        } else if (action == Down && rank > 0) {
            handleKeyDown();
        }
    }

    private void handleKeyEscape(Action action) {
        if (action == Action.Escape && chess.selectedPiece != null) {
            chess.cursor = chess.selectedPiece.getPosition();
            chess.selectedPiece = null;
        }
    }

    private void handleKeyCoup(Action action) {
        if (action == Action.Coup && chess.side == PieceColour.WHITE && chess.selectedPiece == null) {
            chess.side = PieceColour.BLACK;
        } else {
            chess.side = PieceColour.WHITE;
        }
    }

    private Action translateAction(Action action) {
        if (chess.side != PieceColour.WHITE) {
            if (action == Up) {
                action = Down;
            } else if (action == Left) {
                action = Right;
            } else if (action == Right) {
                action = Left;
            } else if (action == Down) {
                action = Up;
            }
        }
        return action;
    }

    private void handleKeyEnter(Action action) {
        if (action == ChessController.Action.Enter) {
            ChessBoard chessBoard = chess.getChessBoard();
            if (chess.selectedPiece == null) {
                chess.selectedPiece = chess.getChessBoard().getPiece(chess.cursor);
                if (chess.selectedPiece != null) {
                    Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
                    int length = chess.selectedPiece.getAvailablePaths(chess.getChessBoard()).length;
                    for (int i = 0; i <= length - 1; i++) {
                        if (availablePaths[i].length != 0) {
                            chess.selectedPath = i;
                            chess.cursor = availablePaths[i][0];
                            break;
                        }
                    }
                }
            } else {
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
            }
        }
    }

    private void handleKeyUp() {
        if (chess.selectedPiece == null) {
            chess.cursor = chess.cursor.getUp();
        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            if (availablePaths.length > chess.selectedPath) {
                for (int i = 0; i <= availablePaths[chess.selectedPath].length - 1; i++) {
                    if (availablePaths[chess.selectedPath][i].equals(chess.cursor)) {
                        if (i + 1 <= availablePaths[chess.selectedPath].length - 1) {
                            chess.cursor = availablePaths[chess.selectedPath][i + 1];
                            break;
                        }
                    }
                }
            }
        }
    }

    private void handleKeyLeft() {
        if (chess.selectedPiece == null) {
            chess.cursor = chess.cursor.getLeft();
        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            int y = 0;
            for (int j = 0; j <= availablePaths.length - 1; j++) {
                if (availablePaths[j].length != 0) {
                    y = y + 1;
                    break;
                }
            }
            if (y == 1) {
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
                            } else if (i == 0) {
                                chess.selectedPath = availablePaths.length;
                                i = availablePaths.length;
                            }
                        }
                    } else {
                        chess.cursor = availablePaths[chess.selectedPath][0];
                    }

                }
            }
        }
    }

    private void handleKeyRight() {
        if (chess.selectedPiece == null) {
            chess.cursor = chess.cursor.getRight();
        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            int y = 0;
            for (int j = 0; j <= availablePaths.length - 1; j++) {
                if (availablePaths[j].length != 0) {
                    y = y + 1;
                    break;
                }
            }
            if (y == 1) {
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
                            } else if (i == availablePaths.length - 1) {
                                chess.selectedPath = -1;
                                i = -1;
                            }
                        }
                    } else {
                        chess.cursor = availablePaths[chess.selectedPath][0];
                    }
                }
            }
        }
    }

    private void handleKeyDown() {
        if (chess.selectedPiece == null) {
            chess.cursor = chess.cursor.getDown();
        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            if (availablePaths.length > chess.selectedPath) {
                for (int i = 0; i <= availablePaths[chess.selectedPath].length - 1; i++) {
                    if (availablePaths[chess.selectedPath][i].equals(chess.cursor)) {
                        if (i - 1 >= 0) {
                            chess.cursor = availablePaths[chess.selectedPath][i - 1];
                            break;
                        }
                    }
                }
            }
        }
    }
}
