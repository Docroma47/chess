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
        // 1. hide (setIsCaptured(true)) all figures except
        //TODO implement me

        // 2. show figure (setIsCaptured(false)) by the "file" and "rank" parameters
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        chessPiece.setIsCaptured(false);

        Random random = new Random();

        // this a loop to emulate chess piece steps, there will 100 steps in total
        for (int i = 0; i < 100; i++) {

            // 2. chose a direction randomly
            // Let say the "direction" variable below can take only 4 values:
            // 0 would mean direction to the "top"
            // 1 would mean direction to the "bottom"
            // 2 would mean direction to the "left"
            // 3 would mean direction to the "right"
            //TODO implement me
            int direction = 0; // generate random value from 0 to 3

            // get a new position
            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);

            // make a step
            chessPiece.setPosition(newPosition);

            // re-print the chess
            chessBashView.print();

            // this method just make you program to sleep for 1 second
            sleep();
        }
    }

    /**
     * This method "moves" position by a direction
     * @param position initial position
     * @param direction direction to move
     * @return new position
     */
    private Point getNewPosition(Point position, int direction) {
        Point newPosition = position;
        if (direction == 0) {
            // move up
            newPosition = moveUp(position);
        } else if (direction == 1) {
            // move down
            newPosition = moveDown(position);
        } else if (direction == 2) {
            // move left
            newPosition = moveLeft(position);
        } else if (direction == 3) {
            // move right
            newPosition = moveRight(position);
        }
        return newPosition;
    }

    private Point moveUp(Point position) {
        //TODO implement me
        // move position to up, e.g. increment rank by 1
        // if the rank becomes greater than 7 (out of the board), then return initial position
        return position;
    }

    private Point moveDown(Point position) {
        //TODO implement me
        // move position to down, e.g. decrement rank by 1
        // if the rank becomes less than 0 (out of the board), then return initial position
        return position;
    }

    private Point moveLeft(Point position) {
        //TODO implement me
        // move position to left, e.g. decrement file by 1
        // if the file becomes less than 0 (out of the board), then return initial position
        return position;
    }

    private Point moveRight(Point position) {
        //TODO implement me
        // move position to right, e.g. increment file by 1
        // if the file becomes more than 7 (out of the board), then return initial position
        return position;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
    }

}
