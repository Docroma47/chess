package org.mom47.chess.model;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void testEquals() {
        Point first = new Point(1, 1);
        Point second = new Point(1, 1);
        
        Assert.assertTrue(first.equals(second));
    }

    @Test
    public void testgetUpPath() {
        Point point = new Point(0, 6);
        Point[] path = point.getUpPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 7));

        Point point1 = new Point(0, 0);
        Point[] path1 = point1.getUpPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(0, 1));
        Assert.assertEquals(path1[1], new Point(0, 2));
        Assert.assertEquals(path1[2], new Point(0, 3));
        Assert.assertEquals(path1[3], new Point(0, 4));
        Assert.assertEquals(path1[4], new Point(0, 5));
        Assert.assertEquals(path1[5], new Point(0, 6));
        Assert.assertEquals(path1[6], new Point(0, 7));

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getUpPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 0);
        Point[] path3 = point3.getUpPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 7);
        Assert.assertEquals(path3[0], new Point(5, 1));
        Assert.assertEquals(path3[1], new Point(5, 2));
        Assert.assertEquals(path3[2], new Point(5, 3));
        Assert.assertEquals(path3[3], new Point(5, 4));
        Assert.assertEquals(path3[4], new Point(5, 5));
        Assert.assertEquals(path3[5], new Point(5, 6));
        Assert.assertEquals(path3[6], new Point(5, 7));

        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getUpPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 4);
        Assert.assertEquals(path4[0], new Point(3, 4));
        Assert.assertEquals(path4[1], new Point(3, 5));
        Assert.assertEquals(path4[2], new Point(3, 6));
        Assert.assertEquals(path4[3], new Point(3, 7));
    }

    @Test
    public void testgetRightPath() {
        Point point = new Point(1, 0);
        Point[] path = point.getLeftPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 0));

        Point point1 = new Point(7, 7);
        Point[] path1 = point1.getLeftPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(6, 7));
        Assert.assertEquals(path1[1], new Point(5, 7));
        Assert.assertEquals(path1[2], new Point(4, 7));
        Assert.assertEquals(path1[3], new Point(3, 7));
        Assert.assertEquals(path1[4], new Point(2, 7));
        Assert.assertEquals(path1[5], new Point(1, 7));
        Assert.assertEquals(path1[6], new Point(0, 7));

        Point point2 = new Point(0, 7);
        Point[] path2 = point2.getLeftPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(2, 0);
        Point[] path3 = point3.getLeftPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 2);
        Assert.assertEquals(path3[0], new Point(1, 0));
        Assert.assertEquals(path3[1], new Point(0, 0));


        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getLeftPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 3);
        Assert.assertEquals(path4[0], new Point(2, 3));
        Assert.assertEquals(path4[1], new Point(1, 3));
        Assert.assertEquals(path4[2], new Point(0, 3));
    }

    @Test
    public void testgetLeftPath() {
        Point point = new Point(6, 0);
        Point[] path = point.getRightPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 0));

        Point point1 = new Point(0, 7);
        Point[] path1 = point1.getRightPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(1, 7));
        Assert.assertEquals(path1[1], new Point(2, 7));
        Assert.assertEquals(path1[2], new Point(3, 7));
        Assert.assertEquals(path1[3], new Point(4, 7));
        Assert.assertEquals(path1[4], new Point(5, 7));
        Assert.assertEquals(path1[5], new Point(6, 7));
        Assert.assertEquals(path1[6], new Point(7, 7));

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getRightPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 0);
        Point[] path3 = point3.getRightPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 2);
        Assert.assertEquals(path3[0], new Point(6, 0));
        Assert.assertEquals(path3[1], new Point(7, 0));


        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getRightPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 4);
        Assert.assertEquals(path4[0], new Point(4, 3));
        Assert.assertEquals(path4[1], new Point(5, 3));
        Assert.assertEquals(path4[2], new Point(6, 3));
        Assert.assertEquals(path4[3], new Point(7, 3));
    }

    @Test
    public void testgetDownPath() {
        Point point = new Point(0, 1);
        Point[] path = point.getDownPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 0));

        Point point1 = new Point(0, 7);
        Point[] path1 = point1.getDownPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(0, 6));
        Assert.assertEquals(path1[1], new Point(0, 5));
        Assert.assertEquals(path1[2], new Point(0, 4));
        Assert.assertEquals(path1[3], new Point(0, 3));
        Assert.assertEquals(path1[4], new Point(0, 2));
        Assert.assertEquals(path1[5], new Point(0, 1));
        Assert.assertEquals(path1[6], new Point(0, 0));

        Point point2 = new Point(3, 0);
        Point[] path2 = point2.getDownPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(7, 7);
        Point[] path3 = point3.getDownPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 7);
        Assert.assertEquals(path3[0], new Point(7, 6));
        Assert.assertEquals(path3[1], new Point(7, 5));
        Assert.assertEquals(path3[2], new Point(7, 4));
        Assert.assertEquals(path3[3], new Point(7, 3));
        Assert.assertEquals(path3[4], new Point(7, 2));
        Assert.assertEquals(path3[5], new Point(7, 1));
        Assert.assertEquals(path3[6], new Point(7, 0));

        Point point4 = new Point(3, 4);
        Point[] path4 = point4.getDownPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 4);
        Assert.assertEquals(path4[0], new Point(3, 3));
        Assert.assertEquals(path4[1], new Point(3, 2));
        Assert.assertEquals(path4[2], new Point(3, 1));
        Assert.assertEquals(path4[3], new Point(3, 0));
    }

    @Test
    public void testgetUpLeftPath() {
        Point point = new Point(1, 6);
        Point[] path = point.getUpLeftPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 7));

        Point point1 = new Point(7, 0);
        Point[] path1 = point1.getUpLeftPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(6, 1));
        Assert.assertEquals(path1[1], new Point(5, 2));
        Assert.assertEquals(path1[2], new Point(4, 3));
        Assert.assertEquals(path1[3], new Point(3, 4));
        Assert.assertEquals(path1[4], new Point(2, 5));
        Assert.assertEquals(path1[5], new Point(1, 6));
        Assert.assertEquals(path1[6], new Point(0, 7));

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getUpLeftPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(4, 0);
        Point[] path3 = point3.getUpLeftPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 4);
        Assert.assertEquals(path3[0], new Point(3, 1));
        Assert.assertEquals(path3[1], new Point(2, 2));
        Assert.assertEquals(path3[2], new Point(1, 3));
        Assert.assertEquals(path3[3], new Point(0, 4));


        Point point4 = new Point(4, 4);
        Point[] path4 = point4.getUpLeftPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 3);

        Assert.assertEquals(path4[0], new Point(3, 5));
        Assert.assertEquals(path4[1], new Point(2, 6));
        Assert.assertEquals(path4[2], new Point(1, 7));
    }

    @Test
    public void testgetUpRightPath() {
        Point point = new Point(6, 6);
        Point[] path = point.getUpRightPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 7));

        Point point1 = new Point(0, 0);
        Point[] path1 = point1.getUpRightPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(1, 1));
        Assert.assertEquals(path1[1], new Point(2, 2));
        Assert.assertEquals(path1[2], new Point(3, 3));
        Assert.assertEquals(path1[3], new Point(4, 4));
        Assert.assertEquals(path1[4], new Point(5, 5));
        Assert.assertEquals(path1[5], new Point(6, 6));
        Assert.assertEquals(path1[6], new Point(7, 7));

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getUpRightPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(4, 3);
        Point[] path3 = point3.getUpRightPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 3);
        Assert.assertEquals(path3[0], new Point(5, 4));
        Assert.assertEquals(path3[1], new Point(6, 5));
        Assert.assertEquals(path3[2], new Point(7, 6));


        Point point4 = new Point(4, 4);
        Point[] path4 = point4.getUpRightPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 3);

        Assert.assertEquals(path4[0], new Point(5, 5));
        Assert.assertEquals(path4[1], new Point(6, 6));
        Assert.assertEquals(path4[2], new Point(7, 7));
    }

    @Test
    public void testgetDownLeftPath() {
        Point point = new Point(1, 1);
        Point[] path = point.getDownLeftPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 0));

        Point point1 = new Point(7, 7);
        Point[] path1 = point1.getDownLeftPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(6, 6));
        Assert.assertEquals(path1[1], new Point(5, 5));
        Assert.assertEquals(path1[2], new Point(4, 4));
        Assert.assertEquals(path1[3], new Point(3, 3));
        Assert.assertEquals(path1[4], new Point(2, 2));
        Assert.assertEquals(path1[5], new Point(1, 1));
        Assert.assertEquals(path1[6], new Point(0, 0));

        Point point2 = new Point(0, 0);
        Point[] path2 = point2.getDownLeftPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(7, 3);
        Point[] path3 = point3.getDownLeftPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 3);
        Assert.assertEquals(path3[0], new Point(6, 2));
        Assert.assertEquals(path3[1], new Point(5, 1));
        Assert.assertEquals(path3[2], new Point(4, 0));


        Point point4 = new Point(3, 7);
        Point[] path4 = point4.getDownLeftPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 3);

        Assert.assertEquals(path4[0], new Point(2, 6));
        Assert.assertEquals(path4[1], new Point(1, 5));
        Assert.assertEquals(path4[2], new Point(0, 4));
    }

    @Test
    public void testgetDownRightPath() {
        Point point = new Point(6, 1);
        Point[] path = point.getDownRightPath(7);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 0));

        Point point1 = new Point(0, 7);
        Point[] path1 = point1.getDownRightPath(7);
        int x1 = path1.length;

        Assert.assertEquals(x1, 7);
        Assert.assertEquals(path1[0], new Point(1, 6));
        Assert.assertEquals(path1[1], new Point(2, 5));
        Assert.assertEquals(path1[2], new Point(3, 4));
        Assert.assertEquals(path1[3], new Point(4, 3));
        Assert.assertEquals(path1[4], new Point(5, 2));
        Assert.assertEquals(path1[5], new Point(6, 1));
        Assert.assertEquals(path1[6], new Point(7, 0));

        Point point2 = new Point(7, 7);
        Point[] path2 = point2.getDownRightPath(7);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(4, 3);
        Point[] path3 = point3.getDownRightPath(7);
        int x3 = path3.length;

        Assert.assertEquals(x3, 3);
        Assert.assertEquals(path3[0], new Point(5, 2));
        Assert.assertEquals(path3[1], new Point(6, 1));
        Assert.assertEquals(path3[2], new Point(7, 0));


        Point point4 = new Point(4, 4);
        Point[] path4 = point4.getDownRightPath(7);
        int x4 = path4.length;

        Assert.assertEquals(x4, 3);

        Assert.assertEquals(path4[0], new Point(5, 3));
        Assert.assertEquals(path4[1], new Point(6, 2));
        Assert.assertEquals(path4[2], new Point(7, 1));
    }

    @Test
    public void testgetUpLeftHorsePath() {
        Point point = new Point(1, 0);
        Point[] path = point.getUpLeftHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 2));

        Point point1 = new Point(7, 0);
        Point[] path1 = point1.getUpLeftHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(6, 2));

        Point point2 = new Point(1, 6);
        Point[] path2 = point2.getUpLeftHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(2, 0);
        Point[] path3 = point3.getUpLeftHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(1, 2));


        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getUpLeftHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(2, 5));
    }

    @Test
    public void testgetUpRightHorsePath() {
        Point point = new Point(6, 0);
        Point[] path = point.getUpRightHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 2));

        Point point1 = new Point(0, 0);
        Point[] path1 = point1.getUpRightHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(1, 2));

        Point point2 = new Point(6, 6);
        Point[] path2 = point2.getUpRightHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 0);
        Point[] path3 = point3.getUpRightHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(6, 2));



        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getUpRightHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(4, 5));
    }

    @Test
    public void testgetDownLeftHorsePath() {
        Point point = new Point(1, 2);
        Point[] path = point.getDownLeftHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 0));

        Point point1 = new Point(5, 7);
        Point[] path1 = point1.getDownLeftHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(4, 5));

        Point point2 = new Point(0, 0);
        Point[] path2 = point2.getDownLeftHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(2, 7);
        Point[] path3 = point3.getDownLeftHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(1, 5));

        Point point4 = new Point(3, 4);
        Point[] path4 = point4.getDownLeftHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(2, 2));
    }

    @Test
    public void testgetDownRightHorsePath() {
        Point point = new Point(1, 2);
        Point[] path = point.getDownRightHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(2, 0));

        Point point1 = new Point(6, 2);
        Point[] path1 = point1.getDownRightHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(7, 0));

        Point point2 = new Point(1, 0);
        Point[] path2 = point2.getDownRightHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(2, 2);
        Point[] path3 = point3.getDownRightHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(3, 0));

        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getDownRightHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(4, 1));
    }

    @Test
    public void testgetRightUpHorsePath() {
        Point point = new Point(5, 1);
        Point[] path = point.getRightUpHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 2));

        Point point1 = new Point(1, 0);
        Point[] path1 = point1.getRightUpHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(3, 1));

        Point point2 = new Point(7, 2);
        Point[] path2 = point2.getRightUpHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(3, 5);
        Point[] path3 = point3.getRightUpHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(5, 6));

        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getRightUpHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(5, 4));
    }

    @Test
    public void testgetRightDownHorsePath() {
        Point point = new Point(5, 2);
        Point[] path = point.getRightDownHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(7, 1));

        Point point1 = new Point(1, 4);
        Point[] path1 = point1.getRightDownHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(3, 3));

        Point point2 = new Point(7, 2);
        Point[] path2 = point2.getRightDownHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(3, 1);
        Point[] path3 = point3.getRightDownHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(5, 0));

        Point point4 = new Point(3, 3);
        Point[] path4 = point4.getRightDownHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(5, 2));
    }

    @Test
    public void testgetLeftUpHorsePath() {
        Point point = new Point(2, 0);
        Point[] path = point.getLeftUpHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 1));

        Point point1 = new Point(6, 0);
        Point[] path1 = point1.getLeftUpHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(4, 1));

        Point point2 = new Point(0, 2);
        Point[] path2 = point2.getLeftUpHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 0);
        Point[] path3 = point3.getLeftUpHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(3, 1));

        Point point4 = new Point(4, 3);
        Point[] path4 = point4.getLeftUpHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(2, 4));
    }

    @Test
    public void testgetLeftDownHorsePath() {
        Point point = new Point(2, 1);
        Point[] path = point.getLeftDownHorsePath(1);
        int x = path.length;

        Assert.assertEquals(x, 1);
        Assert.assertEquals(path[0], new Point(0, 0));

        Point point1 = new Point(7, 3);
        Point[] path1 = point1.getLeftDownHorsePath(1);
        int x1 = path1.length;

        Assert.assertEquals(x1, 1);
        Assert.assertEquals(path1[0], new Point(5, 2));

        Point point2 = new Point(0, 0);
        Point[] path2 = point2.getLeftDownHorsePath(1);
        int x2 = path2.length;

        Assert.assertEquals(x2, 0);

        Point point3 = new Point(5, 5);
        Point[] path3 = point3.getLeftDownHorsePath(1);
        int x3 = path3.length;

        Assert.assertEquals(x3, 1);
        Assert.assertEquals(path3[0], new Point(3, 4));


        Point point4 = new Point(4, 3);
        Point[] path4 = point4.getLeftDownHorsePath(1);
        int x4 = path4.length;

        Assert.assertEquals(x4, 1);
        Assert.assertEquals(path4[0], new Point(2, 2));
    }
}