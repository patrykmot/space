package com.vegasoft.simulation.graphics;

import com.vegasoft.simulation.calc.Vector3D;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SphereTest {

    @Test
    public void testIt() {
        List<Vector3D> points = Sphere.calculatePoints(6, 10);

        Assert.assertNotNull(points);
//        Assert.assertEquals(6, points.size());
    }
}
