package com.vegasoft.simulation.calc;

public interface ForceCalculator {
    Vector3D calculateForceFromAtoB(PhysicalBody a, PhysicalBody b);
}
