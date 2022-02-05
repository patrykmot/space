package com.vegasoft.simulation.calc;

import org.apache.commons.math3.util.FastMath;

public class ForceCalculatorGravity implements ForceCalculator {
    private double g = 6.674e-11;

    public ForceCalculatorGravity() {

    }

    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        double m = a.getM() * b.getM();
        Vector3D diffLocation = b.getLocation().copy().subtract(a.getLocation());
        double r = diffLocation.getLength();
        // Gravity force
        double force = (g * m) / FastMath.pow(r, 2);
        Vector3D forceVec = diffLocation.normalize().mapMultiply(force);
        return forceVec;
    }
}
