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
            chessPiece.setPosition(new Point(random.nextInt(8), random.nextInt(8)));
        }
    }

    public void move(int file, int rank) {
        for (int i = 0; i <= 31; i++) {
            chess.getChessPieces()[i].setIsCaptured(true);
        }

        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        chessPiece.setIsCaptured(false);

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int direction;
            direction = random.nextInt(4);

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);
            
            chessPiece.setPosition(newPosition);

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
            newPosition = moveRight(position);
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

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
    }

}
