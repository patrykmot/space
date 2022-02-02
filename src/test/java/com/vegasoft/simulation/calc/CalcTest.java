package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    private static final double DELTA = 0.000001;

    @Test
    public void calcCartesian() {
        double theta = Calc.degreeToRadians(45.0);
        double phi = Calc.degreeToRadians(45.0);
        double r = 10;
        Vector3D vec = Calc.sphereToCartesianCoordinates(theta, phi, r);
        Assert.assertEquals(r, vec.getLength(), 0.000001);
    }

    @Test
    public void calcCartesianZeroY() {
        double theta = Calc.degreeToRadians(0);
        double phi = Calc.degreeToRadians(45);
        double r = 10;
        Vector3D vec = Calc.sphereToCartesianCoordinates(theta, phi, r);
        Assert.assertEquals(r, vec.getLength(), DELTA);
        Assert.assertEquals(0.0, vec.getY(), DELTA);
    }
}
