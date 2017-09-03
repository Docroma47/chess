package org.mom47.chess;


import org.mom47.chess.controller.FunController;
import org.mom47.chess.model.Chess;
import org.mom47.chess.view.ChessBashView;

public class App {
    private Chess chess;
    private ChessBashView chessBashView;
    private FunController funController;

    public App() {
        chess = new Chess();
        chessBashView = new ChessBashView(chess);
        funController = new FunController(chess, chessBashView);
    }

    public void run() {
        chessBashView.print();
    }
    public static void main(String[] args) {
        App app = new App();
        if (args.length > 0) {
            if (args[0].equals("random")) {
                app.funController.mixRandomlyChessPieces();
            } else if (args[0].equals("move")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                app.funController.move(file, rank);
            } else if (args[0].equals("snake")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                int mix = Integer.valueOf(args[3]);
                app.funController.moveSnake(file, rank, mix);
            } else if (args[0].equals("massacre")) {
                int mix = Integer.valueOf(args[1]);
                app.funController.massacre(mix);
            } else if (args[0].equals("tag")) {
                int mix = Integer.valueOf(args[1]);
                app.funController.tag(mix);
            } else if (args[0].equals("crazy-wander")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                app.funController.crazyWander(file, rank);
            }
        }
        app.run();
    }
}
