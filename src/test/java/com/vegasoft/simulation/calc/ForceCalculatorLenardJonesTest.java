package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

public class ForceCalculatorLenardJonesTest {

    public static final double DELTA = 0.00001;

    @Test
    public void testZeroForce() {
        double ro = 5;
        double rm = Math.pow(2, 1 / 6.0) * ro;
        ForceCalculatorLenardJones calc = new ForceCalculatorLenardJones(10, ro);

        PhysicalBody ph1 = new PhysicalBody();
        ph1.setLocation(Vector3D.create(0, 0, 0));
        PhysicalBody ph2 = new PhysicalBody();
        ph2.setLocation(Vector3D.create(rm, 0, 0));

        Vector3D force = calc.calculateForceWhichAGetsFromB(ph1, ph2);

        Assert.assertEquals(0.0d, force.getX(), DELTA);
        Assert.assertEquals(0.0d, force.getY(), DELTA);
        Assert.assertEquals(0.0d, force.getZ(), DELTA);
    }

    @Test
    public void testCloseForce() {
        double ro = 5;
        ForceCalculatorLenardJones calc = new ForceCalculatorLenardJones(10, ro);
        double rm = calc.calculateZeroForceDistanceRm();

        PhysicalBody ph1 = new PhysicalBody();
        ph1.setLocation(Vector3D.create(0, 0, 0));
        PhysicalBody ph2 = new PhysicalBody();
        ph2.setLocation(Vector3D.create(rm - 0.5, 0, 0));

        Vector3D force = calc.calculateForceWhichAGetsFromB(ph1, ph2);

        Assert.assertEquals(-77.08428988d, force.getX(), DELTA);
        Assert.assertEquals(0.0d, force.getY(), DELTA);
        Assert.assertEquals(0.0d, force.getZ(), DELTA);
    }

    @Test
    public void testFarForce() {
        double ro = 5;
        ForceCalculatorLenardJones calc = new ForceCalculatorLenardJones(10, ro);
        double rm = calc.calculateZeroForceDistanceRm();

        PhysicalBody ph1 = new PhysicalBody();
        ph1.setLocation(Vector3D.create(0, 0, 0));
        PhysicalBody ph2 = new PhysicalBody();
        ph2.setLocation(Vector3D.create(rm + 0.5, 0, 0));

        Vector3D force = calc.calculateForceWhichAGetsFromB(ph1, ph2);

        Assert.assertEquals(11.78671174d, force.getX(), DELTA);
        Assert.assertEquals(0.0d, force.getY(), DELTA);
        Assert.assertEquals(0.0d, force.getZ(), DELTA);
    }
}
