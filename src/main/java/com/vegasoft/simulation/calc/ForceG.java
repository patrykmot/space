package com.vegasoft.simulation.calc;

public class ForceG implements ForceCalculator {
    private final Vector3D G = Vector3D.create(0, -9.81, 0);

    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        return G.copy().mapMultiply(a.getM());
    }
}
