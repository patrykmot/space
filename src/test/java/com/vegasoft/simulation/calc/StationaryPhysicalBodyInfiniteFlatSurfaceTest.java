package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

public class StationaryPhysicalBodyInfiniteFlatSurfaceTest {

    @Test
    public void testSimple() {
        Vector3D position = new Vector3D(1, 1, 1);
        Vector3D direction = new Vector3D(1, 1, 1);
        StationaryPhysicalBodyInfiniteFlatSurface surface = new StationaryPhysicalBodyInfiniteFlatSurface(position, direction);
        PhysicalBody pb = new PhysicalBody();
        pb.setLocation(new Vector3D(2, 2, 2));
        double distance = surface.calculateDistanceTo(pb).getLength();
        double distanceExpected = new Vector3D(1, 1, 1).getLength();
        assertEquals(distance, distanceExpected);
    }

    @Test
    public void testSimple2() {
        Vector3D position = new Vector3D(2, 0, 0);
        Vector3D direction = new Vector3D(1, 0, 0);
        StationaryPhysicalBodyInfiniteFlatSurface surface = new StationaryPhysicalBodyInfiniteFlatSurface(position, direction);
        PhysicalBody pb = new PhysicalBody();
        pb.setLocation(new Vector3D(10, 0, 0));
        double distance = surface.calculateDistanceTo(pb).getLength();
        assertEquals(distance, 8.0);
    }

    private void assertEquals(double distance, double distanceExpected) {
        Assert.assertEquals(distanceExpected, distance, 0.000001);
    }
}
