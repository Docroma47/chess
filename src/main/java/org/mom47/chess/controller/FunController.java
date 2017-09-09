package org.mom47.chess.controller;

import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;

import java.util.Random;

public class FunController {
    private Chess chess;
    private ChessBashView chessBashView;

    public FunController(Chess chess, ChessBashView chessBashView) {
        this.chess = chess;
        this.chessBashView = chessBashView;
    }

    private ChessPiece findChessPiece(int file, int rank) {
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        return chessPiece;
    }

    private int getRandomDirection(ChessPiece chessPiece) {
        Random random = new Random();
        int direction;
        if (chessPiece.getPieceType().equals(PieceType.PAWN) && chessPiece.getColor().equals(PieceColour.WHITE)) {
            direction = 0;
        } else if (chessPiece.getPieceType().equals(PieceType.PAWN) && chessPiece.getColor().equals(PieceColour.BLACK)) {
            direction = 1;
        } else if (chessPiece.getPieceType().equals(PieceType.QUEEN)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.BISHOP)) {
            direction = 3 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.KING)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.ROOK)) {
            direction = random.nextInt(4);
        } else {
            direction = 7 + random.nextInt(4) + 1;
        }
        return direction;
    }

    private int getNextDirection(ChessPiece chessPiece, int direction) {
        Random random = new Random();
        //PawnLogic
        if (chessPiece.getPieceType().equals(PieceType.PAWN) && chessPiece.getPosition().getRank() == 7 && chessPiece.getColor().equals(PieceColour.WHITE)) {
            direction = 0;
        }
        if (chessPiece.getPieceType().equals(PieceType.PAWN) && chessPiece.getPosition().getRank() == 7 && chessPiece.getColor().equals(PieceColour.BLACK)) {
            direction = 1;
        }
        //QueenLogic
        if (chessPiece.getPieceType().equals(PieceType.QUEEN) && chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.QUEEN) && chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.QUEEN) && chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.QUEEN) && chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
            direction = random.nextInt(8);
        }
        //KingLogic
        if (chessPiece.getPieceType().equals(PieceType.KING) && chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.KING) && chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.KING) && chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
            direction = random.nextInt(8);
        } else if (chessPiece.getPieceType().equals(PieceType.KING) && chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
            direction = random.nextInt(8);
        }
        //BishopLogic
        if (chessPiece.getPieceType().equals(PieceType.BISHOP) && chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
            direction = 3 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.BISHOP) && chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
            direction = 3 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.BISHOP) && chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
            direction = 3 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.BISHOP) && chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
            direction = 3 + random.nextInt(4) + 1;
        }
        //RookLogic
        if (chessPiece.getPieceType().equals(PieceType.ROOK) && chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
            direction = random.nextInt(4);
        } else if (chessPiece.getPieceType().equals(PieceType.ROOK) && chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
            direction = random.nextInt(4);
        } else if (chessPiece.getPieceType().equals(PieceType.ROOK) && chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
            direction = random.nextInt(4);
        } else if (chessPiece.getPieceType().equals(PieceType.ROOK) && chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
            direction = random.nextInt(4);
        }
        //KnightLogic
        if (chessPiece.getPieceType().equals(PieceType.KNIGHT) && chessPiece.getPosition().getRank() == 7 && (direction == 8 || direction == 9 || direction == 10 || direction == 11)) {
            direction = 7 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.KNIGHT) && chessPiece.getPosition().getRank() == 0 && (direction == 8 || direction == 9 || direction == 10 || direction == 11)) {
            direction = 7 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.KNIGHT) && chessPiece.getPosition().getFile() == 0 && (direction == 8 || direction == 9 || direction == 10 || direction == 11)) {
            direction = 7 + random.nextInt(4) + 1;
        } else if (chessPiece.getPieceType().equals(PieceType.KNIGHT) && chessPiece.getPosition().getFile() == 7 && (direction == 8 || direction == 9 || direction == 10 || direction == 11)) {
            direction = 7 + random.nextInt(4) + 1;
        }
        return direction;
    }

    private int checkEmptyCellsDirection(int direction, Point newPosition, ChessPiece chessPiece) {
        Random random = new Random();
        if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.PAWN)) {
        } else if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.QUEEN)) {
            direction = random.nextInt(8);
        } else if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.KING)) {
            direction = random.nextInt(8);
        } else if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.BISHOP)) {
            direction = 3 + random.nextInt(4) + 1;
        } else if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.ROOK)) {
            direction = random.nextInt(4);
        } else if (chess.getChessBoard().getPiece(newPosition) != null && chessPiece.getPieceType().equals(PieceType.KNIGHT)) {
            direction = 7 + random.nextInt(4) + 1;
        } else {
            chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
        }

        return direction;
    }

    public int[] getRandomIndexes(int length) {
        Random random = new Random();
        int[] indexes = new int[length];
        for (int i = 0; i < length; i++) {
            indexes[i] = i;
        }

        for(int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(31);
            int temp = indexes[i];
            indexes[i] = indexes[randomIndex];
            indexes[randomIndex] = temp;
        }
        return indexes;
    }

    private void hideChessPiecesRandomlyExcept(ChessPiece chessPiece, int chessPieceNumberToHide) {
        int[] randomIndex = getRandomIndexes(32);
        ChessPiece[] pieceFigures = chess.getChessPieces();
        int indexChessPiece = 0;
        int indexRandomIndex = 0;
        for (int i = 0; i <= 31; i++) {
            if (pieceFigures[i].equals(chessPiece)) {
                indexChessPiece = i;
            }
        }

        for (int i = 0; i <= 31; i++) {
            if (randomIndex[i] == indexChessPiece) {
                indexRandomIndex = i;
            }
        }

        int temp = randomIndex[indexRandomIndex];
        randomIndex[indexRandomIndex] = randomIndex[0];
        randomIndex[0] = temp;

        for (int i = chessPieceNumberToHide; i <= chessPieceNumberToHide; i++) {
            chess.getChessBoard().remove(pieceFigures[randomIndex[i]].getPosition());
        }
    }

    private void shuffleChessPieces() {
        int x = chess.getChessBoard().getChessPiecesNumber();
        ChessPiece[] piece = chess.getChessBoard().getChessPieces();
        for (int i = 1; i <= x - 1; i++) {
            ChessPiece pieces = piece[i];
            Point randomSquire = getRandomFreeSquire();
            chess.getChessBoard().move(pieces.getPosition(), new Point(randomSquire.getFile(), randomSquire.getRank()));
        }
    }

    public void crazyWander(int file, int rank, int hidePiece) {
        ChessPiece chessPiece = findChessPiece(file, rank);

        hideChessPiecesRandomlyExcept(chessPiece, hidePiece);
        shuffleChessPieces();

        int direction = getRandomDirection(chessPiece);

        for (int i = 0; i < 500; i++) {
            direction = getNextDirection(chessPiece, direction);

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);
            direction = checkEmptyCellsDirection(direction, newPosition, chessPiece);
            chessBashView.print();
            sleep();
        }
    }

    public void mixRandomlyChessPieces() {
        for (int i = 0; i <= 31; i++) {
            Random random = new Random();
            ChessPiece chessPiece = chess.getChessPieces()[i];
            chess.getChessBoard().move(chessPiece.getPosition(), new Point(random.nextInt(8), random.nextInt(8)));
        }
    }

    private Point getRandomFreeSquire() {
        Random random = new Random();
        Point[] freeSquires = chess.getChessBoard().getFreeSquires();
        int x = random.nextInt(freeSquires.length);
        return chess.getChessBoard().getFreeSquires()[x];
    }

    public void massacre(int mix) {
        Random random = new Random();
        for (int j = 0; j <= mix; j++) {
            ChessPiece piece = chess.getChessPieces()[random.nextInt(31)];
            Point randomSquire = getRandomFreeSquire();
            chess.getChessBoard().move(piece.getPosition(), new Point(randomSquire.getFile(), randomSquire.getRank()));
        }

        for (int i = mix; i <= 31; i++) {
            chess.getChessBoard().remove(chess.getChessPieces()[i].getPosition());
        }

        ChessPiece chessPiece = chess.getChessBoard().getChessPieces()[random.nextInt(chess.getChessBoard().getChessPiecesNumber())];


        int direction;
        direction = random.nextInt(8);
        for (int i = 0; i < 500; i++) {
            if (chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
                direction = random.nextInt(8);
            }

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);

            if (chess.getChessBoard().getPiece(newPosition) != null && chess.getChessBoard().getPiece(newPosition).getColor() != chessPiece.getColor()) {
                chess.getChessBoard().remove(newPosition);
                chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
            } else if (chess.getChessBoard().getPiece(newPosition) != null && chess.getChessBoard().getPiece(newPosition).getColor() == chessPiece.getColor()) {
                direction = random.nextInt(8);
            } else {
                chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
            }
            chessBashView.print();
            sleep();
        }
    }

    public void tag(int mix) {
        Random random = new Random();
        for (int j = 0; j <= mix; j++) {
            ChessPiece piece = chess.getChessPieces()[random.nextInt(31)];
            Point randomSquire = getRandomFreeSquire();
            chess.getChessBoard().move(piece.getPosition(), new Point(randomSquire.getFile(), randomSquire.getRank()));
        }

        for (int i = mix; i <= 31; i++) {
            chess.getChessBoard().remove(chess.getChessPieces()[i].getPosition());
        }

        ChessPiece chessPiece = chess.getChessBoard().getChessPieces()[random.nextInt(chess.getChessBoard().getChessPiecesNumber())];


        int direction;
        direction = random.nextInt(8);
        for (int i = 0; i < 500; i++) {
            if (chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
                direction = random.nextInt(8);
            }

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);

            if (chess.getChessBoard().getPiece(newPosition) != null && chess.getChessBoard().getPiece(newPosition).getColor() != chessPiece.getColor()) {
                chessPiece = chess.getChessBoard().getPiece(newPosition);
            } else if (chess.getChessBoard().getPiece(newPosition) != null && chess.getChessBoard().getPiece(newPosition).getColor() == chessPiece.getColor()) {
                direction = random.nextInt(8);
            } else {
                chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
            }
            chessBashView.print();
            sleep();
        }
    }



    public void moveSnake(int file, int rank, int mix) {
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));

        for (int j = 0; j <= mix; j++) {
            ChessPiece piece = chess.getChessPieces()[j];
            Point randomSquire = getRandomFreeSquire();
            chess.getChessBoard().move(piece.getPosition(), new Point(randomSquire.getFile(), randomSquire.getRank()));
        }

        for (int i = mix; i <= 31; i++) {
            if (chess.getChessPieces()[i] == chess.getChessBoard().getPiece(new Point(file, rank))) {
            } else {
                chess.getChessBoard().remove(chess.getChessPieces()[i].getPosition());
            }
        }

        Random random = new Random();
        int direction;
        direction = random.nextInt(8);

        for (int i = 0; i < 500; i++) {
            if (chessPiece.getPosition().getRank() == 7 && (direction == 0 || direction == 4 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getRank() == 0 && (direction == 1 || direction == 5 || direction == 7)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 0 && (direction == 2 || direction == 5 || direction == 6)) {
                direction = random.nextInt(8);
            } else if (chessPiece.getPosition().getFile() == 7 && (direction == 3 || direction == 4 || direction == 7)) {
                direction = random.nextInt(8);
            }

            Point newPosition = getNewPosition(chessPiece.getPosition(), direction);
            if (chess.getChessBoard().getPiece(newPosition) != null) {
                direction = random.nextInt(8);
            } else {
                chess.getChessBoard().move(chessPiece.getPosition(), newPosition);
            }
            chessBashView.print();
            sleep();
        }

    }

    public void move(int file, int rank) {
        ChessPiece chessPiece = chess.getChessBoard().getPiece(new Point(file, rank));
        for (int i = 0; i <= 31; i++) {
            if (chess.getChessPieces()[i] == chess.getChessBoard().getPiece(new Point(file, rank))) {
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
            newPosition = moveRight(position);
        } else if (direction == 4) {
            newPosition = moveUpRight(position);
        } else if (direction == 5) {
            newPosition = moveDownLeft(position);
        } else if (direction == 6) {
            newPosition = moveUpLeft(position);
        } else if (direction == 7) {
            newPosition = moveDownRight(position);
        } else if (direction == 8) {
            newPosition = moveHorseDownLeft(position);
        } else if (direction == 9) {
            newPosition = moveHorseDownRight(position);
        } else if (direction == 10) {
            newPosition = moveHorseUpLeft(position);
        } else if (direction == 11) {
            newPosition = moveHorseUpRight(position);
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

    private Point moveUpRight(Point position) {
        if (position.getFile() < 7 && position.getRank() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() + 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveDownLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() > 0) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() - 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveDownRight(Point position) {
        if (position.getRank() > 0 && position.getFile() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() - 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveUpLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() < 7) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() + 1;
            return new Point(newFileValue, newRankValue);
        } else {
            return position;
        }
    }

    private Point moveHorseUpRight(Point position) {
        if (position.getFile() < 7 && position.getRank() < 7) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() + 2;
            if (newFileValue > 7 || newRankValue > 7) {
                return position;
            } else {
                return new Point(newFileValue, newRankValue);
            }
        } else {
            return position;
        }
    }

    private Point moveHorseDownLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() > 0) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() - 2;
            if (newFileValue < 0 || newRankValue < 0) {
                return position;
            } else {
                return new Point(newFileValue, newRankValue);
            }
        } else {
            return position;
        }
    }

    private Point moveHorseUpLeft(Point position) {
        if (position.getFile() > 0 && position.getRank() < 7) {
            int newFileValue = position.getFile() - 1;
            int newRankValue = position.getRank() + 2;
            if (newFileValue < 0 || newRankValue > 7) {
                return position;
            } else {
                return new Point(newFileValue, newRankValue);
            }
        } else {
            return position;
        }
    }

    private Point moveHorseDownRight(Point position) {
        if (position.getFile() < 7 && position.getRank() > 0) {
            int newFileValue = position.getFile() + 1;
            int newRankValue = position.getRank() - 2;
            if (newFileValue > 7 || newRankValue < 0) {
                return position;
            } else {
                return new Point(newFileValue, newRankValue);
            }
        } else {
            return position;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) { }
    }

}

