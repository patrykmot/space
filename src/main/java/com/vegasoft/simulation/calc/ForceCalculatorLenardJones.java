package com.vegasoft.simulation.calc;

import org.apache.commons.math3.util.FastMath;

public class ForceCalculatorLenardJones implements ForceCalculator {

    /**
     * Deep of potential
     */
    private double epsilon;

    /**
     * Zero length (force is zero for it)
     */
    private double ro;

    public ForceCalculatorLenardJones(double epsilon, double ro) {
        this.epsilon = epsilon;
        this.ro = ro;
    }

    @Override
    public Vector3D calculateForceFromAtoB(PhysicalBody a, PhysicalBody b) {
        Vector3D difR = Vector3D.create(a.getLocation().subtract(b.getLocation()));
        double r = difR.getLength();
        double forceValue = -48 * ro * (FastMath.pow(ro / r, 13l) - 0.5 * (FastMath.pow(ro / r, 7l)));
        Vector3D force = Vector3D.create(difR.normalize().mapMultiply(forceValue));
        return force;
    }
}
