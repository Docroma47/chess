package org.mom47.chess.controller;

import org.mom47.chess.model.Chess;
import org.mom47.chess.model.ChessPiece;
import org.mom47.chess.model.Point;
import org.mom47.chess.view.ChessBashView;

import java.util.Random;

public class FunController {
    private Chess chess;
    private ChessBashView chessBashView;

    public FunController(Chess chess, ChessBashView chessBashView) {
        this.chess = chess;
        this.chessBashView = chessBashView;
    }

    public void mixRandomlyChessPieces() {
        for (int i = 0; i <= 31; i++) {
            Random random = new Random();
            ChessPiece chessPiece = chess.getChessPieces()[i];
            chess.getChessBoard().move(chessPiece.getPosition(), new Point(random.nextInt(8), random.nextInt(8)));
        }
    }

    public void moveSnake(int file, int rank) {
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        for (int i = 0; i <= 31; i++) {
            if(chess.getChessPieces()[i] == chess.getChessBoard().getPiece(new Point(file, rank))) {
            } else {
                chess.getChessBoard().remove(chess.getChessPieces()[i].getPosition());
            }
        }


        Random random = new Random();

        int direction;
        direction = random.nextInt(4);
        for (int i = 0; i < 100; i++) {
            if (chessPiece.getPosition().getRank() == 7 && direction == 0 || direction == 4 || direction == 6) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getRank() == 0 && direction == 1 || direction == 5 || direction == 7) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 0 && direction == 2 || direction == 5 || direction == 6) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 7 && direction == 3 || direction == 4 || direction == 7) {
                direction = random.nextInt(8);
            }
            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);
            chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
            chessBashView.print();
            sleep();
        }

    }

    public void move(int file, int rank) {
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        for (int i = 0; i <= 31; i++) {
            if(chess.getChessPieces()[i] == chess.getChessBoard().getPiece(new Point(file, rank))) {
            } else {
                chess.getChessBoard().remove(chess.getChessPieces()[i].getPosition());
            }
        }


        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int direction;
            direction = random.nextInt(4);

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);

            chess.getChessBoard().move(chessPiece.getPosition(), newPosition);

            chessBashView.print();

            sleep();
        }
    }

    private Point getNewPosition(Point position, int direction) {
        Point newPosition = position;
        if (direction == 0) {
            newPosition = moveUp(position);
        } else if (direction == 1) {
            newPosition = moveDown(position);
        } else if (direction == 2) {
            newPosition = moveLeft(position);
        } else if (direction == 3) {
            newPosition = moveRight(position);// UpRight, UpLeft, DownRight, DownLeft
        } else if (direction == 4) {
            newPosition = UpRight(position);
        } else if (direction == 5) {
            newPosition = DownLeft(position);
        } else if (direction == 6) {
            newPosition = UpLeft(position);
        } else if (direction == 7) {
            newPosition = DownRight(position);
        }
        return newPosition;
    }

    private Point moveUp(Point position) {
        if (position.getRank() < 7) {
            int newFileValue = position.getFile();
            int newRankValue = position.getRank() + 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveDown(Point position) {
        if (position.getRank() > 0) {
            int newFileValue = position.getFile();
            int newRankValue = position.getRank() - 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveLeft(Point position) {
        if (position.getFile() > 0) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank();
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveRight(Point position) {
        if (position.getFile() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank();
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }
    // И вот это последнее чо добавил.
    private Point UpRight(Point position) {
        if (position.getFile() < 7 && position.getRank() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() + 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point DownLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() > 0) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() - 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point DownRight(Point position) {
        if (position.getRank() > 0 && position.getFile() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() - 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point UpLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() < 7) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() + 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
    }

}
