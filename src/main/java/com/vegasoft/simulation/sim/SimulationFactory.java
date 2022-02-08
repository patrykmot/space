package com.vegasoft.simulation.sim;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class SimulationFactory {

    private static Map<String, Class<? extends SimulationFactory>> factories = new HashMap<>();

    static {
        registerFactory(SimMarkWeberTelescope.class);
        registerFactory(SimParticles.class);
        registerFactory(SimParticlesWithGravity.class);
        registerFactory(SimParticlesTwoGroups.class);
    }

    private static void registerFactory(Class<? extends SimulationFactory> factoryClass) {
        String name = getLast(factoryClass.getName().split("\\."));
        if (factories.containsKey(name)) {
            throw new SimulationException("Class " + name + " already registered.");
        }
        factories.put(name, factoryClass);
    }

    private static String getLast(String[] split) {
        return split[split.length - 1];
    }

    public static SimulationFactory findFactory(String name) {
        try {
            SimulationFactory sf = Optional.ofNullable(factories.get(name))
                    .orElseThrow(() -> new SimulationException("Can't find simulation with name " + name))
                    .getDeclaredConstructor().newInstance();
            return sf;
        } catch (Exception e) {
            throw new SimulationException(e);
        }
    }


    public abstract Simulation createSimulation();

    public abstract Double getLocationScaleFactor();
}
