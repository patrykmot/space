package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

public class ForceCalculatorGravityTest {


    @Test
    public void testGravitySunAndEarth() {
        double forceGravitySunAndEarth = 3.53e22; // Newton

        ForceCalculatorGravity calculatorGravity = new ForceCalculatorGravity();

        PhysicalBody earth = new PhysicalBody();
        earth.setM(5.96e24); // kg

        PhysicalBody sun = new PhysicalBody();
        sun.setLocation(Vector3D.create(1.497e11, 0.0, 0.0)); // meters
        sun.setM(1.99e30); // kg

        Vector3D force = calculatorGravity.calculateForceFromAtoB(earth, sun);
        double forceValue = force.getLength();

        Assert.assertEquals(forceGravitySunAndEarth, forceValue, 1e20);
    }
}
