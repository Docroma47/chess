package org.mom47.chess.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fusesource.jansi.Ansi;
import org.mom47.chess.CheeJSON;
import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;


import java.io.File;
import java.io.IOException;

import static org.mom47.chess.controller.ChessController.Action.*;

public class ChessController {
    private Chess chess;
    private ChessBashView chessBashView;

    public enum Action {
        Up,
        Left,
        Right,
        Down,
        Enter,
        Escape,
        Exit,
        Coup,
        Save,
        Downloading
    }

    public ChessController(Chess chess, ChessBashView chessBashView) {
        this.chess = chess;
        this.chessBashView = chessBashView;
    }

    public void handleKey(Action action, File file) throws IOException {
        action = translateAction(action);
        handleArrowKeys(action);
        handleKeyEnter(action);
        handleKeyCoup(action);
        handleEscapeKey(action);
        handleKeySave(action, chess, file);
    }

    private void handleKeySave(Action action, Chess chess, File file) throws IOException {
        if (action == Save) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, chess);
            System.out.println(Ansi.ansi().cursor(22, 0).fg(Ansi.Color.WHITE).a("JSON Save"));
        }
    }


    private void handleArrowKeys(Action action) {
        if (action == Up) {
            handleKeyUp();
        } else if (action == Left) {
            handleKeyLeft();
        } else if (action == Right) {
            handleKeyRight();
        } else if (action == Down) {
            handleKeyDown();
        }
    }

    private void handleEscapeKey(Action action) {
        if (action == Action.Escape && chess.selectedPiece != null) {
            chess.cursor = chess.selectedPiece.getPosition();
            chess.selectedPiece = null;
        }
    }

    private void handleKeyCoup(Action action) {
        if (action == Action.Coup && chess.side == PieceColour.WHITE && chess.selectedPiece == null) {
            chess.side = PieceColour.BLACK;
        } else if (action == Action.Coup && chess.side == PieceColour.BLACK && chess.selectedPiece == null) {
            chess.side = PieceColour.WHITE;
        }
    }

    private Action translateAction(Action action) {
        if (chess.side != PieceColour.WHITE && chess.selectedPiece == null) {
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
                if (chess.selectedPiece != null && chess.selectedPiece.getColor() == chess.side) {
                    Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
                    int length = chess.selectedPiece.getAvailablePaths(chess.getChessBoard()).length;
                    for (int i = 0; i <= length - 1; i++) {
                        if (availablePaths[i].length != 0) {
                            chess.selectedPath = i;
                            chess.cursor = availablePaths[i][0];
                            break;
                        }
                    }
                } else {
                    chess.selectedPiece = null;
                }
            } else {
                if (chessBoard.getPiece(chess.cursor) != null) {
                    if (chess.selectedPiece.getColor() != chessBoard.getPiece(chess.cursor).getColor()) {
                        chessBoard.getPiece(chess.cursor).setIsCaptured(false);
                        chessBoard.remove(chess.cursor);
                        chess.getChessBoard().move(chess.selectedPiece.getPosition(), chess.cursor);
                        chess.selectedPiece = null;
                        changeSidePieceColour();
                    }
                } else {
                    chess.getChessBoard().move(chess.selectedPiece.getPosition(), chess.cursor);
                    chess.selectedPiece = null;
                    changeSidePieceColour();
                }
            }
        }
    }

    private void handleKeyUp() {
        if (chess.selectedPiece == null) {
            int rank = chess.cursor.getRank();
            if (rank < 7) {
                chess.cursor = chess.cursor.getUp();
            }
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
            int file = chess.cursor.getFile();
            if (file > 0) {
            chess.cursor = chess.cursor.getLeft();}

        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            if (checkForDeadEnd()) {
                chess.selectedPath = getPreviousPathIndex(availablePaths);
                chess.cursor = availablePaths[chess.selectedPath][0];
            }
        }
    }

    private int getNextPathIndex(Point[][] availablePaths) {
        int nextIndex = chess.selectedPath;
        while (true) {
            nextIndex++;
            if (nextIndex >= availablePaths.length) {
                nextIndex = -1;
            } else if (availablePaths[nextIndex].length > 0) {
                return nextIndex;
            }
        }
    }

    private int getPreviousPathIndex(Point[][] availablePaths) {
        int nextIndex = chess.selectedPath;
        while (true) {
            nextIndex--;
            if (nextIndex <= -1) {
                nextIndex = availablePaths.length;
            } else if (availablePaths[nextIndex].length > 0) {
                return nextIndex;
            }
        }
    }

    private void handleKeyRight() {
        if (chess.selectedPiece == null) {
            int file = chess.cursor.getFile();
            if (file < 7) {
                chess.cursor = chess.cursor.getRight();
            }
        } else {
            ChessBoard chessBoard = chess.getChessBoard();
            Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);
            if (checkForDeadEnd()) {
                chess.selectedPath = getNextPathIndex(availablePaths);
                chess.cursor = availablePaths[chess.selectedPath][0];
            }
        }
    }

    private void handleKeyDown() {
        if (chess.selectedPiece == null) {
            int rank = chess.cursor.getRank();
            if (rank > 0) {
                chess.cursor = chess.cursor.getDown();
            }
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

    private boolean checkForDeadEnd() {
        Boolean aBoolean = false;
        ChessBoard chessBoard = chess.getChessBoard();
        Point[][] availablePaths = chess.selectedPiece.getAvailablePaths(chessBoard);

        for (int j = 0; j <= availablePaths.length - 1; j++) {
            if (availablePaths[j].length != 0) {
                aBoolean = true;
            }
        }

        return aBoolean;
    }

    private void changeSidePieceColour() {
        if (chess.side == PieceColour.WHITE && !(chess.isSinglePlayerMode())) {
            chess.side = PieceColour.BLACK;
        } else if (chess.side == PieceColour.BLACK && !(chess.isSinglePlayerMode())) {
            chess.side = PieceColour.WHITE;
        }
    }

    public Action gameEnd(Action action) {
        ChessPiece whiteKing = chess.getChessPieces()[16];
        ChessPiece blackKing = chess.getChessPieces()[24];
        if (whiteKing.getIsCaptured()) {
            chessBashView.printPlayerWin();
            action = Exit;
            return action;
        } else if (blackKing.getIsCaptured()) {
            chessBashView.printPlayerWin();
            action = Exit;
            return action;
        }

        return action;
    }

    public void toJSON(CheeJSON cheeJSON, File file, Action action) throws IOException {
        if (action == Save ) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file.getParentFile().getParentFile(), cheeJSON);
            System.out.println(Ansi.ansi().cursor(22, 0).fg(Ansi.Color.WHITE).a("JSON Save"));
        }
    }

    public Chess toJavaObject(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, Chess.class);
    }
}
