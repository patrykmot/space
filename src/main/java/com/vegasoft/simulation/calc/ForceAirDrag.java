package com.vegasoft.simulation.calc;

public class ForceAirDrag implements ForceCalculator {

    private double minVelocity;

    public ForceAirDrag(double minVelocity) {
        this.minVelocity = minVelocity;
    }

    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        if (a.getVelocity().getLength() > minVelocity) {
            return a.getVelocity().copy().mapMultiply(-1 * a.getAirDragCoefficient());
        } else {
            return Vector3D.getZeroVec();
        }
    }
}
