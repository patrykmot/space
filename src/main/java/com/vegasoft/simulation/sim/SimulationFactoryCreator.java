package com.vegasoft.simulation.sim;

public class SimulationFactoryCreator {

    public static SimulationFactory createFactory(String[] arg) {
        if (arg.length != 1) {
            throw new SimulationException("There must be exactly one argument but found " + arg.length);
        }
        SimulationFactory sf = SimulationFactory.findFactory(arg[0]);
        return sf;
    }
}
