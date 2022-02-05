package com.vegasoft.simulation.sim;

import java.util.Optional;

public class SimulationFactoryCreator {

    private enum SimulationFactoryNames {
        MarkWeberTelescope(SimMarkWeberTelescope.class), SimParticles(SimParticles.class);
        private Class className;

        SimulationFactoryNames(Class<? extends SimulationFactory> className) {
            this.className = className;
        }

        public Class getSimulationFactoryClassName() {
            return className;
        }

        public static Optional<SimulationFactoryNames> find(String name) {
            for (SimulationFactoryNames v : SimulationFactoryNames.values()) {
                if (v.name().equalsIgnoreCase(name)) {
                    return Optional.of(v);
                }
            }
            return Optional.empty();
        }
    }

    public static SimulationFactory createFactory(String[] arg) {
        if (arg.length != 1) {
            throw new SimulationException("There must be exactly one argument but found " + arg.length);
        }
        SimulationFactoryNames name = SimulationFactoryNames.find(arg[0]).orElseThrow(() -> new SimulationException("Can't find simulation with " + arg[0]));
        try {
            SimulationFactory sf = (SimulationFactory) name.getSimulationFactoryClassName().getDeclaredConstructor().newInstance();
            return sf;
        } catch (Exception e) {
            throw new SimulationException(e);
        }
    }
}
