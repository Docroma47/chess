package org.mom47.chess;


import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;

import java.util.Random;

public class App {
    private Chess chess;
    private ChessBashView chessBashView;

    public App() {
        chess = new Chess();
        chessBashView = new ChessBashView(chess);
    }

    public void run() {
        chessBashView.print();
    }
    public static void main(String[] args) {
        App app = new App();
        if (args.length > 0 && args[0].equals("random")) {
            for (int i = 0; i <= 31; i++) {
                Random random = new Random();
                ChessPiece chessPiece = app.chess.getChessPieces()[i];
                chessPiece.setPosition(new Point(random.nextInt(8), random.nextInt(8)));
            }
        }
        app.run();
    }
}
