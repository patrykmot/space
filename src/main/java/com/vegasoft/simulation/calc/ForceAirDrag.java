package com.vegasoft.simulation.calc;

public class ForceAirDrag implements ForceCalculator {
    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        return a.getVelocity().copy().mapMultiply(-1 * a.getAirDragCoefficient());
    }
}
