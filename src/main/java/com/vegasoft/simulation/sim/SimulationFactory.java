package com.vegasoft.simulation.sim;

public interface SimulationFactory {
    Simulation createSimulation();
    Double getLocationScaleFactor();
}
