package com.vegasoft.simulation.calc;

public interface ForceCalculator {
    Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b);
}
