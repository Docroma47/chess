package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;
import org.mom47.chess.controller.FunController;
import org.mom47.chess.view.ChessBashView;

public class FunControllerTest {

    @Test
    public void testGetRandomIndexes() {
        Chess chess = new Chess();
        ChessBashView chessBashView = new ChessBashView(chess);
        FunController funController = new FunController(chess, chessBashView);
        int[] x = funController.getRandomIndexes(30);
        for (int i = 1; i <= 30; i++) {
            System.out.println(x[i]);
        }
    }
}