package com.vegasoft.simulation.calc;

import org.apache.commons.math3.util.FastMath;

public class ForceCalculatorLenardJones implements ForceCalculator {

    private static final double COEF1 = Math.pow(2, 1 / 6.0);
    /**
     * Deep of potential
     */
    private double epsilon;

    /**
     * Zero length (force is zero for it)
     */
    private double ro;

    public ForceCalculatorLenardJones(double epsilon, double rm) {
        this.epsilon = epsilon;
        this.ro = rm / COEF1;
    }

    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        Vector3D difR = b.getLocation().copy().subtract(a.getLocation());
        double r = difR.getLength();
        double forceValue = -48 * ro * (FastMath.pow(ro / r, 13l) - 0.5 * (FastMath.pow(ro / r, 7l)));
        Vector3D force = difR.normalize().mapMultiply(forceValue);
        return force;
    }

    public double calculateZeroForceDistanceRm() {
        return COEF1 * ro;
    }
}
