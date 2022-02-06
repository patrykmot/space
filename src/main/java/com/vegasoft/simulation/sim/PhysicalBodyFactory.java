package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.Particle;

import java.util.List;

public interface PhysicalBodyFactory {
    List<Particle> createBodies();

    double getLocationScaleFactor();
}
