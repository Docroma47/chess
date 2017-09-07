package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;
import org.mom47.chess.controller.FunController;
import org.mom47.chess.view.ChessBashView;

public class FunControllerTest {
    public int variable;
    public int[] variable1 = new int[10];

    @Test
    public void testGetRandomIndexes() {
        Chess chess = new Chess();
        ChessBashView chessBashView = new ChessBashView(chess);
        FunController funController = new FunController(chess, chessBashView);
        int[] x = funController.getRandomIndexes(31);
        for (int i = 1; i <= 31; i++) {
            System.out.println(x[i]);
        }
    }

    @Test
    public void testVariable() {

        System.out.println("variable: " + variable);
        for(int i = 0; i <= 9; i++) {
            System.out.println("variable char: " + variable1[i]);
        }
    }
}
