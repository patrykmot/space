package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

public class ForceCalculatorGravityTest {


    @Test
    public void testGravitySunAndEarth() {
        double forceGravitySunAndEarth = 3.53e22; // Newton

        ForceCalculatorGravity calculatorGravity = new ForceCalculatorGravity();

        Particle earth = new Particle();
        earth.setM(5.96e24); // kg

        Particle sun = new Particle();
        sun.setLocation(Vector3D.create(1.497e11, 0.0, 0.0)); // meters
        sun.setM(1.99e30); // kg

        Vector3D force = calculatorGravity.calculateForceWhichAGetsFromB(earth, sun);
        double forceValue = force.getLength();

        Assert.assertEquals(forceGravitySunAndEarth, forceValue, 1e20);
    }
}
