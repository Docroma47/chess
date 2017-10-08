package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void testEquals() {
        Point first = new Point(1, 1);
        Point second = new Point(1, 1);
        
        Assert.assertEquals(first, second);
    }

    @Test
    public void testgetUpPath() {
        Point point = new Point(0, 6);
        Point[] path = point.getUpPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);

        Point point1 = new Point(0, 0);
        Point[] path1 = point1.getUpPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getUpPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 0);
        Point[] path3 = point3.getUpPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 7);

        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getUpPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 4);
    }

}
