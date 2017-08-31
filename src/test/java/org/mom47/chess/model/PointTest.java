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

}
