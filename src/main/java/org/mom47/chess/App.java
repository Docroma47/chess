package org.mom47.chess;


import org.mom47.chess.model.*;
import org.mom47.chess.view.ChessBashView;
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
        app.run();
    }
}
