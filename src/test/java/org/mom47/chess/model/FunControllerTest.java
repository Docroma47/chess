package org.mom47.chess.model;

import junit.framework.Assert;
import org.junit.Test;
import org.mom47.chess.controller.FunController;
import org.mom47.chess.view.ChessBashView;

public class FunControllerTest {
    public int variable;


    @Test
    public void testGetRandomIndexes() {
        Chess chess = new Chess();
        ChessBashView chessBashView = new ChessBashView(chess);
        FunController funController = new FunController(chess, chessBashView);
        int[] x = funController.getRandomIndexes(64);
        Assert.assertEquals(64, x.length);
        for (int i = 1; i <= 64; i++) {
            System.out.println(x[i]);
        }
    }

    @Test
    public void testVariable() {
        int[] variable1 = new int[10];
        System.out.println("variable: " + variable);
        for(int i = 0; i <= 9; i++) {
            System.out.println("variable char: " + variable1[i]);
        }
    }
}
